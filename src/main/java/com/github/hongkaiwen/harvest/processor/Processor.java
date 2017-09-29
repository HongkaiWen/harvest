package com.github.hongkaiwen.harvest.processor;

import com.github.hongkaiwen.harvest.context.ProcessorContext;
import com.github.hongkaiwen.harvest.intf.Lifecycle;

/**
 * Created by hongkai on 2017/9/26.
 */
public interface Processor extends Lifecycle {

    void process(ProcessorContext context, ProcessorChain chain);

}
