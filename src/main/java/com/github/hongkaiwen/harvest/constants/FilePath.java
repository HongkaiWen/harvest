package com.github.hongkaiwen.harvest.constants;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by hongkai on 2017/9/29.
 */
public interface FilePath {

    String ERROR = "/error";

    String ERROR_IGNORE = "/ignore";

    Date current = new Date();

    static String generateDateTimePath(){
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
        return String.format("/%s", sf.format(current));
    }

}
