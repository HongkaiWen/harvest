package com.github.hongkaiwen.harvest.media;

import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.metadata.Metadata;
import com.drew.metadata.exif.ExifSubIFDDirectory;

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
            return metadata.getFirstDirectoryOfType(ExifSubIFDDirectory.class).getDate(ExifSubIFDDirectory.TAG_DATETIME_ORIGINAL);
        }catch(Exception e){
            return null;
        }
    }

    public static void main(String args[]){
        Date time = new JpegInfoAccessor(new File("E:/私人文件夹/照片170114/IMG_20160721_204518.jpg")).createTime();
        System.out.println(time);
    }
}
