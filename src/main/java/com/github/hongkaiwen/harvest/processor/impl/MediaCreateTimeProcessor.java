package com.github.hongkaiwen.harvest.processor.impl;

import com.github.hongkaiwen.harvest.context.ProcessorContext;
import com.github.hongkaiwen.harvest.media.MediaInfoAccessor;
import com.github.hongkaiwen.harvest.media.MediaInfoAccessorBuilder;
import com.github.hongkaiwen.harvest.processor.Processor;
import com.github.hongkaiwen.harvest.processor.ProcessorChain;

/**
 * Created by hongkai on 2017/9/27.
 */
public class MediaCreateTimeProcessor implements Processor {


    @Override
    public void process(ProcessorContext context, ProcessorChain chain) {
        MediaInfoAccessor accessor = MediaInfoAccessorBuilder.INSTANCE.build(context.getSourceFile());
        if(accessor != null){
            context.getFileInfo().setTackPhotoTime(accessor.createTime());
        }
        chain.doProcess(context);
    }
}
