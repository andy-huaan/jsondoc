var Ajax = {

    createCORSRequest: function(method, url) {
        var xhr = new XMLHttpRequest();
        if ("withCredentials" in xhr) {

            // Check if the XMLHttpRequest object has a "withCredentials" property.
            // "withCredentials" only exists on XMLHTTPRequest2 objects.
            xhr.open(method, url, true);

        } else if (typeof XDomainRequest != "undefined") {

            // Otherwise, check if XDomainRequest.
            // XDomainRequest only exists in IE, and is IE's way of making CORS requests.
            xhr = new XDomainRequest();
            xhr.open(method, url);

        } else {

            // Otherwise, CORS is not supported by the browser.
            xhr = null;

        }
        return xhr;
    },

    request: function(url, options) {
        var xhr = this.createCORSRequest('POST', url);
        if (!xhr) return;
        xhr.withCredentials = true;
        xhr.setRequestHeader('X-REQUESTED-WITH', 'XMLHttpRequest');

        xhr.onreadystatechange = function () {
            if (xhr.readyState != 4) return;
            if (xhr.status != 200 && xhr.status != 304) {
                if (options.onFailure) {
                    options.onFailure(xhr.status, xhr.responseText);
                }
                return;
            }

            options.onSuccess(xhr.responseText);
        };

        if (xhr.readyState == 4) return;
        xhr.send();

        return true;
    }
};

var FlattrButton = {

    doFlattr: function(link) {

        var options = {
            method: 'post',
            onSuccess: function(buffer) {
                window.parent.postMessage(JSON.stringify({
                    'flattr_button_event': 'click_successful',
                }), '*');

                // Update counter
                var counter = document.querySelector('.flattr-count span');
                var count = parseInt(counter.innerHTML) || 0;
                counter.innerHTML = ++count;

                // switch class
                link.className = 'flattr flattr-ed';
                link.querySelector('span.flattr-link').className = 'flattr-flattred';

                // switch url
                var match = link.href.match(/^(.+)\/flattr\/(.+)$/i);
                link.href = match[1] + '/subscribe/' + match[2];

                // switch title
                link.title = 'Subscribe';
            },
            onFailure: function(code, response) {

                if (!window.useEvents && (code == 401 || code == 402)) {
                    response = JSON.parse(response);
                    window.parent.location.href = response.url;
                    return;
                }

                if (code == 401 || code == 402) {
                    window.parent.postMessage(JSON.stringify({
                        'flattr_button_event': 'unauthorized',
                    }), '*');
                    return;
                }

                window.location.reload(true);
            }
        };

        if (!Ajax.request(link.href, options)) {
            window.location.reload(true);
        }
    },

    doSubscribe: function(lnk) {

        var options = {
            method: 'post',
            onSuccess: function(buffer) {
                window.parent.postMessage(JSON.stringify({
                    'flattr_button_event': 'subscribe_successful',
                }), '*');

                var innerSpan = document.createElement('span');
                innerSpan.className = 'flattr-subscribed';

                var span = document.createElement('span');
                span.className = 'flattr';
                span.appendChild(innerSpan);

                lnk.parentNode.replaceChild(span, lnk);
            },
            onFailure: function(code, message) {
                window.location.reload(true);
            }
        };

        Ajax.request(lnk.href, options);
    },

    init: function() {
        if (!document.querySelectorAll) {
            // Remove the button in IE7?
            var container = document.getElementsByTagName('div')[0];
            container.parentNode.removeChild(container);
            return;
        }

        var i, length, arr = document.querySelectorAll('.flattr');
        for (i = 0, length = arr.length; i < length; i++) {
            arr[i].onclick = function() {
                if (/\bflattr-ajax\b/.test(this.className)) {
                    FlattrButton.doFlattr(this);
                } else if (/\bflattr-ed\b/.test(this.className)) {
                    FlattrButton.doSubscribe(this);
                }
                return false;
            };
        }
    },

};

window.onload = function(){ FlattrButton.init(); };
