package com.github.hongkaiwen.harvest.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by hongkai on 2017/9/27.
 */
public class HarvestFileUtils {

    public static String getSuffix(File f){
        String name = f.getName();
        return name.substring(name.lastIndexOf(".") + 1, name.length()).toLowerCase();
    }

    public static File appendTimeStamp(File source, File file){
        String  fileNameAppendTimeStamp = fileNameAppendTimeStamp(source);
        return new File(String.format("%s/%s", file.getPath(), fileNameAppendTimeStamp));
    }

    private static String fileNameAppendTimeStamp(File file){
        String nameWithoutSuffix = file.getName().substring(0, file.getName().lastIndexOf("."));
        String suffix = getSuffix(file);
        return String.format("%s-%d.%s", nameWithoutSuffix, System.currentTimeMillis(),suffix);
    }

    public static void main(String args[]){
        File temp = new File("E:\\私人文件夹\\照片170114\\IMG_20170107_130232.jpg");
        System.out.println(fileNameAppendTimeStamp(temp));
    }
}
