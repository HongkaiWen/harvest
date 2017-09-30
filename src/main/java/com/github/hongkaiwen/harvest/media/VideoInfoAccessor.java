package com.github.hongkaiwen.harvest.media;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Date;

/**
 * Created by hongkai on 2017/9/27.
 */
public class VideoInfoAccessor implements MediaInfoAccessor {

    private static final Logger logger = LoggerFactory.getLogger(VideoInfoAccessor.class);

    private File mediaFile;

    public VideoInfoAccessor(File mediaFile) {
        this.mediaFile = mediaFile;
    }

    @Override
    public Date createTime() {
        try{
            long lastModified = mediaFile.lastModified();
            return new Date(lastModified);
        }catch(Exception e){
            logger.error("read video file time error: " + mediaFile.toString(), e);
            return null;
        }
    }

    public static void main(String args[]){
        Date time = new VideoInfoAccessor(new File("E:/私人文件夹/照片170114/VID_20170107_105717.mp4")).createTime();
        System.out.println(time);
    }
}
