package com.github.hongkaiwen.harvest.processor.impl;

import com.github.hongkaiwen.harvest.action.MoveAction;
import com.github.hongkaiwen.harvest.action.WriteCheckSumAction;
import com.github.hongkaiwen.harvest.constants.FilePath;
import com.github.hongkaiwen.harvest.constants.MediaType;
import com.github.hongkaiwen.harvest.context.ProcessorContext;
import com.github.hongkaiwen.harvest.processor.Processor;
import com.github.hongkaiwen.harvest.processor.ProcessorChain;

import java.io.File;
import java.util.Date;

/**
 * Created by hongkai on 2017/9/30.
 */
public class Move2RepositoryProcessor implements Processor {


    @Override
    public void process(ProcessorContext context, ProcessorChain chain) {
        MediaType mediaType = context.getFileInfo().getMediaType();
        Date takePhotoTime = context.getFileInfo().getTakePhotoTime();
        String generateFilePath = FilePath.generateFilePath(mediaType, takePhotoTime);
        //移动文件到仓库
        context.getActionList().add(new MoveAction(context.getSourceFile(), new File(generateFilePath)));
        //写入checkSum 信息
        context.getActionList().add(new WriteCheckSumAction(String.format("%s/%s", generateFilePath, context.getSourceFile().getName()), context.getFileInfo().getCheckSum()));
        chain.doProcess(context);
    }

}
