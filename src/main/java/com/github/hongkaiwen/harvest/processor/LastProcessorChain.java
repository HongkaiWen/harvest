package com.github.hongkaiwen.harvest.processor;

import com.github.hongkaiwen.harvest.BootApplication;
import com.github.hongkaiwen.harvest.context.ProcessorContext;
import com.github.hongkaiwen.harvest.docker.DockerPool;
import com.github.hongkaiwen.harvest.docker.DockerTask;

/**
 * Created by hongkai on 2017/9/26.
 */
public class LastProcessorChain implements ProcessorChain {

    @Override
    public void doProcess(ProcessorContext context) {
        if(!context.isSkipOtherProcessor()){
            BootApplication.addFiles.incrementAndGet();
        }
        DockerPool.executor.execute(new DockerTask(context.getActionList()));
    }
}
