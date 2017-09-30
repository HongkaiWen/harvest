package com.github.hongkaiwen.harvest.context;

import com.github.hongkaiwen.harvest.constants.MediaType;

import java.util.Date;

/**
 * Created by hongkai on 2017/9/27.
 */
public class FileInfo {

    private String checkSum;

    private Date takePhotoTime;

    private MediaType mediaType;

    public String getCheckSum() {
        return checkSum;
    }

    public void setCheckSum(String checkSum) {
        this.checkSum = checkSum;
    }

    public Date getTakePhotoTime() {
        return takePhotoTime;
    }

    public void setTakePhotoTime(Date takePhotoTime) {
        this.takePhotoTime = takePhotoTime;
    }

    public MediaType getMediaType() {
        return mediaType;
    }

    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType;
    }
}
