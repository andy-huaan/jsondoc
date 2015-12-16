package com.breadenglish.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.engine.loading.internal.CollectionLoadContext;
import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import java.util.Collection;
import java.util.Date;

/**
 * Created by jiangkun on 15/12/15.
 */
@ApiObject
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class WordOfTheDay {
    @ApiObjectField(description = "ID",required = true)
    private int id;

    @ApiObjectField(description = "标题")
    private String title;

    @ApiObjectField(description = "简介")
    private String intro;

    @ApiObjectField(description = "更新日期")
    private Date dt;

    @ApiObjectField(description = "图片预览")
    private String preview;

    @ApiObjectField(description = "详情大图")
    private String fullSizeImage;

    @ApiObjectField(description = "子标题数组")
    private Collection<WordOfTheDaySubTitle> subtitle;

    public static WordOfTheDay buildDetails(int id, String title, String intro, Date dt, String preview, String fullSizeImage, Collection<WordOfTheDaySubTitle> subtitle) {
        WordOfTheDay wordOfTheDay=new WordOfTheDay();
        wordOfTheDay.id = id;
        wordOfTheDay.title = title;
        wordOfTheDay.intro = intro;
        wordOfTheDay.dt = dt;
        wordOfTheDay.preview = preview;
        wordOfTheDay.fullSizeImage = fullSizeImage;
        wordOfTheDay.subtitle = subtitle;
        return wordOfTheDay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Date getDt() {
        return dt;
    }

    public void setDt(Date dt) {
        this.dt = dt;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public String getFullSizeImage() {
        return fullSizeImage;
    }

    public void setFullSizeImage(String fullSizeImage) {
        this.fullSizeImage = fullSizeImage;
    }

    public Collection<WordOfTheDaySubTitle> getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(Collection<WordOfTheDaySubTitle> subtitle) {
        this.subtitle = subtitle;
    }
}
