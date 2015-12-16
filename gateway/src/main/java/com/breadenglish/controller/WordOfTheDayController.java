package com.breadenglish.controller;

import com.breadenglish.model.WordOfTheDay;
import org.jsondoc.core.annotation.*;
import org.jsondoc.core.pojo.ApiStage;
import org.jsondoc.core.pojo.ApiVisibility;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

@Api(name = "每日一词", description = "每日一词资源服务", group = "基础数据", visibility = ApiVisibility.PUBLIC, stage = ApiStage.RC)
@ApiVersion(since = "1.0", until = "2.12")
@ApiAuthNone
@RestController
@RequestMapping(value = "/wordoftheday")
public class WordOfTheDayController {
    HashMap<Integer, WordOfTheDay> data = new HashMap();

    public WordOfTheDayController() {
        data.put(1, WordOfTheDay.buildDetails(1, "强迫症的看过来!3", "3OCD - Obsessive Compulsive Disorder", new Date(), "http://m.breadenglish.com/Content/RwdImages/M/logo.png", "fullSizeImage", null));
        data.put(2, WordOfTheDay.buildDetails(2, "强迫症的看过来!3", "3OCD - Obsessive Compulsive Disorder", new Date(), "http://m.breadenglish.com/Content/RwdImages/M/logo.png", "fullSizeImage", null));
        data.put(3, WordOfTheDay.buildDetails(3, "强迫症的看过来!3", "3OCD - Obsessive Compulsive Disorder", new Date(), "http://m.breadenglish.com/Content/RwdImages/M/logo.png", "fullSizeImage", null));
    }

    @ApiMethod
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public
    @ApiResponseObject
    WordOfTheDay getById(@ApiPathParam(description = "根据ID获取每日一词数据") @PathVariable(value = "id") int id) {
        return data.get(id);
    }

    @ApiMethod
    @RequestMapping(method = RequestMethod.GET)
    public
    @ApiResponseObject
    Collection<WordOfTheDay> get(@ApiQueryParam(name="page",required = false, description = "页号") @RequestParam(required = false, defaultValue = "0") int page, @ApiQueryParam(name="pageSize",required = false,description = "每页Size") @RequestParam(required = false, defaultValue = "0") int pageSize) {
        return data.values();
    }
}