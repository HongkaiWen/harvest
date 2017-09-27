package com.github.hongkaiwen.harvest.util;

import java.io.File;

/**
 * Created by hongkai on 2017/9/27.
 */
public class HarvestFileUtils {

    public static String getSuffix(File f){
        String name = f.getName();
        return name.substring(name.lastIndexOf(".") + 1, name.length()).toLowerCase();
    }
}
