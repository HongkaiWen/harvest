package com.github.hongkaiwen.harvest.context;

import com.github.hongkaiwen.harvest.constants.MediaType;

import java.util.Date;

/**
 * Created by hongkai on 2017/9/27.
 */
public class FileInfo {

    private String checkSum;

    private Date tackPhotoTime;

    private MediaType mediaType;

    public String getCheckSum() {
        return checkSum;
    }

    public void setCheckSum(String checkSum) {
        this.checkSum = checkSum;
    }

    public Date getTackPhotoTime() {
        return tackPhotoTime;
    }

    public void setTackPhotoTime(Date tackPhotoTime) {
        this.tackPhotoTime = tackPhotoTime;
    }

    public MediaType getMediaType() {
        return mediaType;
    }

    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType;
    }
}
