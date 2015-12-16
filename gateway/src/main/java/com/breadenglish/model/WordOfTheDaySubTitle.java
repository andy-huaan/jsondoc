package com.breadenglish.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

/**
 * Created by jiangkun on 15/12/15.
 */
@ApiObject
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class WordOfTheDaySubTitle {

    @ApiObjectField(description = "子标题")
    private String subtitle;

    @ApiObjectField(description = "详细内容")
    private String content;

    public WordOfTheDaySubTitle() {
    }

    public WordOfTheDaySubTitle(String subtitle, String content) {
        this.subtitle = subtitle;
        this.content = content;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
