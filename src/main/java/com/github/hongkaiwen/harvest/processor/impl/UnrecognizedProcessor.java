package com.github.hongkaiwen.harvest.processor.impl;

import com.github.hongkaiwen.harvest.action.MoveAction;
import com.github.hongkaiwen.harvest.constants.CommonConstants;
import com.github.hongkaiwen.harvest.constants.FilePath;
import com.github.hongkaiwen.harvest.context.ProcessorContext;
import com.github.hongkaiwen.harvest.processor.Processor;
import com.github.hongkaiwen.harvest.processor.ProcessorChain;
import com.github.hongkaiwen.harvest.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Date;

/**
 * Created by hongkai on 2017/9/30.
 */
public class UnrecognizedProcessor implements Processor {

    private static final Logger logger = LoggerFactory.getLogger(UnrecognizedProcessor.class);

    @Override
    public void process(ProcessorContext context, ProcessorChain chain) {
        Date takePhotoTime = context.getFileInfo().getTakePhotoTime();
        String checkSum = context.getFileInfo().getCheckSum();
        if(takePhotoTime == null){
            context.setSkipOtherProcessor(true);
            File unrecognizedPath = new File(String.format("%s%s%s%s", CommonConstants.REPOSITORY_ROOT, FilePath.UNRECOGNIZED, FilePath.generateDateTimePath(), FilePath.UNRECOGNIZED_DATE));
            context.getActionList().add(new MoveAction(context.getSourceFile(), unrecognizedPath));
            logger.warn("Unrecognized file found, please check it" + context.getSourceFile().toString());
        } else if(StringUtils.isEmpty(checkSum)){
            context.setSkipOtherProcessor(true);
            File unrecognizedPath = new File(String.format("%s%s%s%s", CommonConstants.REPOSITORY_ROOT, FilePath.UNRECOGNIZED, FilePath.generateDateTimePath(), FilePath.UNRECOGNIZED_CHECKSUM));
            context.getActionList().add(new MoveAction(context.getSourceFile(), unrecognizedPath));
            logger.warn("Unrecognized file found, please check it" + context.getSourceFile().toString());
        }
        chain.doProcess(context);
    }
}
