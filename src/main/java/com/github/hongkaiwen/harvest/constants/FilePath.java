package com.github.hongkaiwen.harvest.constants;

import com.github.hongkaiwen.harvest.BootApplication;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by hongkai on 2017/9/29.
 */
public interface FilePath {

    String ERROR = "/error";

    String ERROR_IGNORE = "/ignore";

    String PHOTOS = "/photos";

    String VIDEOS = "/videos";

    String UNRECOGNIZED = "/unrecognized";

    String REPOSITORY = "/repository";

    String DATA = "/data";

    String IGNORE_REPOSITORY = "/ignore-repository";

    static String getIgnoreRepositoryPath(){
        return String.format("%s%s%s%s", CommonConstants.REPOSITORY_ROOT, ERROR, generateDateTimePath(), IGNORE_REPOSITORY);
    }

    static String generateDateTimePath() {
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
        return String.format("/%s", sf.format(BootApplication.CURRENT_TIME));
    }

    static String generateFilePath(MediaType mediaType, Date takePhotoTime) {
        StringBuilder root = new StringBuilder(String.format("%s%s", CommonConstants.REPOSITORY_ROOT, REPOSITORY));
        if (MediaType.PHOTO.equals(mediaType)) {
            root.append(PHOTOS);
        } else {
            root.append(VIDEOS);
        }
        root.append(getPathByDate(takePhotoTime));
        return root.toString();
    }

    static String getPathByDate(Date tackPhotoTime){
        if(tackPhotoTime == null){
            return String.format("%s%s", UNRECOGNIZED, generateDateTimePath());
        }
        SimpleDateFormat sf = new SimpleDateFormat("/yyyy/MM");
        return sf.format(tackPhotoTime);
    }

    static String getDataPath(){
        return String.format("%s%s", CommonConstants.REPOSITORY_ROOT, DATA);
    }

}
