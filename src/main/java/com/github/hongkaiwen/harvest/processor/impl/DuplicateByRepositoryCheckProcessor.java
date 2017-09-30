package com.github.hongkaiwen.harvest.processor.impl;

import com.github.hongkaiwen.harvest.action.MoveAction;
import com.github.hongkaiwen.harvest.constants.FilePath;
import com.github.hongkaiwen.harvest.context.ProcessorContext;
import com.github.hongkaiwen.harvest.processor.Processor;
import com.github.hongkaiwen.harvest.processor.ProcessorChain;

import java.io.File;

/**
 * Created by hongkai on 2017/9/29.
 */
public class DuplicateByRepositoryCheckProcessor implements Processor {

    @Override
    public void process(ProcessorContext context, ProcessorChain chain) {
        String checkSum = context.getFileInfo().getCheckSum();
        File checkSumFile = new File(String.format("%s/%s.DAT", FilePath.getDataPath(), checkSum));
        if (checkSumFile.exists()) {
            //与仓库中的文件重复
            context.getActionList().add(new MoveAction(context.getSourceFile(), new File(FilePath.getIgnoreRepositoryPath())));
            context.setSkipOtherProcessor(true);
        }
        chain.doProcess(context);
    }

}
