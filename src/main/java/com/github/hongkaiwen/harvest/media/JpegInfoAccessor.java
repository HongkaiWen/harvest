package com.github.hongkaiwen.harvest.media;

import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.metadata.Metadata;
import com.drew.metadata.exif.ExifSubIFDDirectory;
import com.drew.metadata.file.FileMetadataDirectory;

import java.io.File;
import java.util.Date;

/**
 * Created by hongkai on 2017/9/27.
 */
public class JpegInfoAccessor implements MediaInfoAccessor {

    private File mediaFile;

    public JpegInfoAccessor(File mediaFile) {
        this.mediaFile = mediaFile;
    }

    @Override
    public Date createTime() {
        try{
            Metadata metadata = JpegMetadataReader.readMetadata(this.mediaFile);
            Date photoTime = metadata.getFirstDirectoryOfType(ExifSubIFDDirectory.class).getDate(ExifSubIFDDirectory.TAG_DATETIME_ORIGINAL);
            if(photoTime == null){
                photoTime = metadata.getFirstDirectoryOfType(FileMetadataDirectory.class).getDate(FileMetadataDirectory.TAG_FILE_MODIFIED_DATE);
            }
            return photoTime;
        }catch(Exception e){
            return null;
        }
    }

    public static void main(String args[]){
        Date time = new JpegInfoAccessor(new File("E:/私人文件夹/照片170114/IMG_20161112_130719.jpg")).createTime();
        System.out.println(time);
    }
}
