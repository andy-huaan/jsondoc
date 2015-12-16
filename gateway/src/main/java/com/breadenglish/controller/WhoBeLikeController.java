package com.breadenglish.controller;


import com.breadenglish.model.WhoBeLike;
import org.jsondoc.core.annotation.*;
import org.jsondoc.core.pojo.ApiStage;
import org.jsondoc.core.pojo.ApiVisibility;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

@Api(name = "Who be like", description = "资源服务接口", group = "基础数据", visibility = ApiVisibility.PUBLIC, stage = ApiStage.RC)
@ApiVersion(since = "1.0", until = "2.12")
@ApiAuthNone
@RestController
@RequestMapping(value = "/whobelikes")
public class WhoBeLikeController {
    HashMap<Integer, WhoBeLike> data = new HashMap();

    public WhoBeLikeController() {
        data.put(1, WhoBeLike.buildDetails(1, "强迫症的看过来!", "OCD - Obsessive Compulsive Disorder", new Date(), "http://m.breadenglish.com/Content/RwdImages/M/logo.png", "audioUrl", "fullSizeImage", "nextTitle", "backgoundMusic", "no"));
        data.put(2, WhoBeLike.buildDetails(2, "强迫症的看过来!2", "2OCD - Obsessive Compulsive Disorder", new Date(), "http://m.breadenglish.com/Content/RwdImages/M/logo.png", "audioUrl", "fullSizeImage", "nextTitle", "backgoundMusic", "no"));
        data.put(3, WhoBeLike.buildDetails(3, "强迫症的看过来!3", "3OCD - Obsessive Compulsive Disorder", new Date(), "http://m.breadenglish.com/Content/RwdImages/M/logo.png", "audioUrl", "fullSizeImage", "nextTitle", "backgoundMusic", "no"));
    }

    @ApiMethod
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public
    @ApiResponseObject
    WhoBeLike getById(@ApiPathParam(description = "根据ID获取whobelike数据") @PathVariable(value = "id") int id) {
        return data.get(id);
    }

    @ApiMethod
    @RequestMapping(value = "/allDatas",method = RequestMethod.GET)
    public
    @ApiResponseObject
    Collection<WhoBeLike> get(@ApiQueryParam(name="page",required = false, description = "页号")
                              @RequestParam(required = false, defaultValue = "0") int page,
                              @ApiQueryParam(name="pageSize",required = false,description = "每页Size")
                              @RequestParam(required = false, defaultValue = "0") int pageSize) {
        return data.values();
    }
}