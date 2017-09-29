package com.github.hongkaiwen.harvest.processor.impl;

import com.github.hongkaiwen.harvest.action.MoveAction;
import com.github.hongkaiwen.harvest.constants.FilePath;
import com.github.hongkaiwen.harvest.context.ProcessorContext;
import com.github.hongkaiwen.harvest.processor.Processor;
import com.github.hongkaiwen.harvest.processor.ProcessorChain;

import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by hongkai on 2017/9/29.
 */
public class DuplicateCheckProcessor implements Processor {

    private static final ConcurrentHashMap mediaCheckSumHolders = new ConcurrentHashMap();

    private static final Object value = new Object();

    @Override
    public void process(ProcessorContext context, ProcessorChain chain) {
        String checkSum = context.getFileInfo().getCheckSum();
        Object existValue = mediaCheckSumHolders.putIfAbsent(checkSum, value);
        if (existValue != null) {
            context.setSkipOtherProcessor(true);
            MoveAction moveAction = new MoveAction(context.getSourceFile(), new File(String.format("%s%s%s", FilePath.ERROR,
                    FilePath.generateDateTimePath(), FilePath.ERROR_IGNORE)));
            context.getActionList().add(moveAction);
        }
        chain.doProcess(context);
    }

    @Override
    public void destroy() {
        DuplicateCheckProcessor.mediaCheckSumHolders.clear();
    }
}
