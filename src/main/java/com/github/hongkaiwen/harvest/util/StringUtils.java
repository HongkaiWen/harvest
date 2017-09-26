package com.github.hongkaiwen.harvest.util;

/**
 * Created by hongkai on 2017/9/26.
 */
public class StringUtils {

    public static boolean isEmpty(String str){
        return str == null || str.trim().length() == 0;
    }
}
