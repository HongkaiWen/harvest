package com.github.hongkaiwen.harvest.media;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.metadata.Metadata;
import com.drew.metadata.exif.ExifSubIFDDirectory;
import com.drew.metadata.file.FileMetadataReader;

import java.io.File;
import java.util.Date;

/**
 * Created by hongkai on 2017/9/27.
 */
public class Mp4InfoAccessor implements MediaInfoAccessor {

    private File mediaFile;

    public Mp4InfoAccessor(File mediaFile) {
        this.mediaFile = mediaFile;
    }

    @Override
    public Date createTime() {
        try{
            Metadata metadata = ImageMetadataReader.readMetadata(this.mediaFile);
            metadata.getDirectories().forEach(t->System.out.println(t));
            return metadata.getFirstDirectoryOfType(ExifSubIFDDirectory.class).getDate(ExifSubIFDDirectory.TAG_DATETIME_ORIGINAL);
        }catch(Exception e){
            return null;
        }
    }

    public static void main(String args[]){
        Date time = new Mp4InfoAccessor(new File("E:/私人文件夹/照片170114/VID_20170107_105717.mp4")).createTime();
        System.out.println(time);
    }
}
