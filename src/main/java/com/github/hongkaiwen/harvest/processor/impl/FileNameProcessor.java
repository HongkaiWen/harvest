package com.github.hongkaiwen.harvest.processor.impl;

import com.github.hongkaiwen.harvest.context.ProcessorContext;
import com.github.hongkaiwen.harvest.operate.Action;
import com.github.hongkaiwen.harvest.operate.ActionType;
import com.github.hongkaiwen.harvest.processor.Processor;
import com.github.hongkaiwen.harvest.processor.ProcessorChain;

import java.io.File;

/**
 * Created by hongkai on 2017/9/26.
 */
public class FileNameProcessor implements Processor {

    @Override
    public void process(ProcessorContext context, ProcessorChain chain) {
        File sourceFile = context.getSourceFile();
        System.out.println(sourceFile.getName());

        Action action = new Action();
        action.setActionType(ActionType.COPY);

        context.getActionList().add(action);

        chain.doProcess(context);
    }
}
