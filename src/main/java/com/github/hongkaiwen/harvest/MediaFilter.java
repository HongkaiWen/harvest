package com.github.hongkaiwen.harvest;

import com.github.hongkaiwen.harvest.constants.CommonConstants;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

/**
 * Created by hongkai on 2017/9/26.
 */
public class MediaFilter implements FileFilter{

    @Override
    public boolean accept(File file) {
        String suffix;
        try{
            suffix = getSuffix(file);
        } catch (Exception e){
            return false;
        }

        if(!Arrays.asList(CommonConstants.SUFFIX_PHOTO).contains(suffix) && !Arrays.asList(CommonConstants.SUFFIX_VEDIO).contains(suffix)){
            return false;
        }
        return true;
    }

    private String getSuffix(File file){
        String name = file.getName();
        return name.substring(name.lastIndexOf(".") + 1, name.length()).toLowerCase();
    }
}
