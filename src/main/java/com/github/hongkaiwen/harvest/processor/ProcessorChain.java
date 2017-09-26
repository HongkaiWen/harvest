package com.github.hongkaiwen.harvest.processor;

import com.github.hongkaiwen.harvest.context.ProcessorContext;

/**
 * Created by hongkai on 2017/9/26.
 */
public interface ProcessorChain {

    void doProcess(ProcessorContext context);

}
