package com.github.hongkaiwen.harvest.util;


import org.apache.commons.codec.digest.DigestUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5CaculateUtil {

    public static String getHash(File target) throws IOException, NoSuchAlgorithmException{

        InputStream ins = new FileInputStream(target);
        
        byte[] buffer = new byte[8192];
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        
        int len;
        while((len = ins.read(buffer)) != -1){
            md5.update(buffer, 0, len);
        }

        ins.close();
        return DigestUtils.md5Hex(md5.digest());
    }
    
}