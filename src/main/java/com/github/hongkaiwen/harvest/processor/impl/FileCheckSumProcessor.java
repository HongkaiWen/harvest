package com.github.hongkaiwen.harvest.processor.impl;

import com.github.hongkaiwen.harvest.context.ProcessorContext;
import com.github.hongkaiwen.harvest.processor.Processor;
import com.github.hongkaiwen.harvest.processor.ProcessorChain;
import com.github.hongkaiwen.harvest.util.Md5CaculateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * Created by hongkai on 2017/9/27.
 */
public class FileCheckSumProcessor implements Processor {

    private static final Logger logger = LoggerFactory.getLogger(FileCheckSumProcessor.class);

    @Override
    public void process(ProcessorContext context, ProcessorChain chain) {
        File sourceFile = context.getSourceFile();
        try {
            context.getFileInfo().setCheckSum(Md5CaculateUtil.getHash(sourceFile));
            chain.doProcess(context);
        } catch (Exception e) {
            logger.error("file check sum failed: " + sourceFile.getName(), e);
        }
    }
}
