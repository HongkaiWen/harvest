package com.github.hongkaiwen.harvest.processor.impl;

import com.github.hongkaiwen.harvest.constants.MediaType;
import com.github.hongkaiwen.harvest.context.ProcessorContext;
import com.github.hongkaiwen.harvest.processor.Processor;
import com.github.hongkaiwen.harvest.processor.ProcessorChain;
import com.github.hongkaiwen.harvest.util.HarvestFileUtils;

/**
 * Created by hongkai on 2017/9/29.
 */
public class FileTypeProcessor implements Processor {

    @Override
    public void process(ProcessorContext context, ProcessorChain chain) {
        String suffix = HarvestFileUtils.getSuffix(context.getSourceFile());
        if("jpg".equals(suffix) || "jpeg".equals(suffix) || "png".equals(suffix)){
           context.getFileInfo().setMediaType(MediaType.PHOTO);
        }
        if("mp4".equals(suffix) || "mov".equals(suffix)){
            context.getFileInfo().setMediaType(MediaType.VEDIO);
        }
        chain.doProcess(context);
    }
}
