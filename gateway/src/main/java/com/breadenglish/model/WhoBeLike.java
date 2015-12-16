package com.breadenglish.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import java.util.Date;

/**
 * Created by jiangkun on 15/12/15.
 */
@ApiObject
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class WhoBeLike {
    @ApiObjectField(description = "ID")
    private int id;

    @ApiObjectField(description = "标题")
    private String title;

    @ApiObjectField(description = "简介")
    private String intro;

    @ApiObjectField(description = "更新日期")
    private Date dt;

    @ApiObjectField(description = "图片预览")
    private String preview;

    @ApiObjectField(description = "语音文件地址",required = true)
    private String audioUrl;

    @ApiObjectField(description = "详情大图")
    private String fullSizeImage;

    @ApiObjectField(description = "下一期标题")
    private String nextTitle;

    @ApiObjectField(description = "今天的背景音乐")
    private String backgroundMusic;

    @ApiObjectField(description = "编号,客户端title上显示")
    private String no;

    public static WhoBeLike buildDetails(int id, String title, String intro, Date dt, String preview, String audioUrl, String fullSizeImage, String nextTitle, String backgroundMusic,String no) {
        WhoBeLike whoBeLike = new WhoBeLike();
        whoBeLike.id = id;
        whoBeLike.title = title;
        whoBeLike.intro = intro;
        whoBeLike.dt = dt;
        whoBeLike.preview = preview;
        whoBeLike.audioUrl = audioUrl;
        whoBeLike.fullSizeImage = fullSizeImage;
        whoBeLike.nextTitle = nextTitle;
        whoBeLike.backgroundMusic = backgroundMusic;
        whoBeLike.no = no;
        return whoBeLike;
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

    public String getAudioUrl() {
        return audioUrl;
    }

    public void setAudioUrl(String audioUrl) {
        this.audioUrl = audioUrl;
    }

    public String getFullSizeImage() {
        return fullSizeImage;
    }

    public void setFullSizeImage(String fullSizeImage) {
        this.fullSizeImage = fullSizeImage;
    }

    public String getNextTitle() {
        return nextTitle;
    }

    public void setNextTitle(String nextTitle) {
        this.nextTitle = nextTitle;
    }

    public String getBackgroundMusic() {
        return backgroundMusic;
    }

    public void setBackgroundMusic(String backgroundMusic) {
        this.backgroundMusic = backgroundMusic;
    }
}
