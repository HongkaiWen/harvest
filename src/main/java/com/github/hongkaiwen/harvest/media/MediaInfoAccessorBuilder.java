package com.github.hongkaiwen.harvest.media;

import com.github.hongkaiwen.harvest.util.HarvestFileUtils;

import java.io.File;

/**
 * Created by hongkai on 2017/9/27.
 */
public enum  MediaInfoAccessorBuilder {

    INSTANCE;

    public MediaInfoAccessor build(File mediaFile){
        String suffix = HarvestFileUtils.getSuffix(mediaFile);
        if("jpg".equals(suffix) || "jpeg".equals(suffix)){
            return new JpegInfoAccessor(mediaFile);
        }
        return new VideoInfoAccessor(mediaFile);
    }
}
