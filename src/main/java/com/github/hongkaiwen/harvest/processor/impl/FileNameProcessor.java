package com.github.hongkaiwen.harvest.processor.impl;

import com.github.hongkaiwen.harvest.context.ProcessorContext;
import com.github.hongkaiwen.harvest.processor.Processor;
import com.github.hongkaiwen.harvest.processor.ProcessorChain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * Created by hongkai on 2017/9/26.
 */
public class FileNameProcessor implements Processor {


    private static final Logger logger = LoggerFactory.getLogger(FileNameProcessor.class);

    @Override
    public void process(ProcessorContext context, ProcessorChain chain) {
        File sourceFile = context.getSourceFile();
        logger.debug(String.format("file name : %s, check sum %s, create time %s, type: %s",
                sourceFile.getName(),
                context.getFileInfo().getCheckSum(),
                context.getFileInfo().getTakePhotoTime(),
                context.getFileInfo().getMediaType()
        ));
        chain.doProcess(context);
    }
}
