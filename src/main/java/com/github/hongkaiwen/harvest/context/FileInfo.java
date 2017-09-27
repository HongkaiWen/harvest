package com.github.hongkaiwen.harvest.context;

import java.util.Date;

/**
 * Created by hongkai on 2017/9/27.
 */
public class FileInfo {

    private String checkSum;

    private Date tackPhotoTime;

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
}
