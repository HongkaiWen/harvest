package com.github.hongkaiwen.harvest.processor;

import com.github.hongkaiwen.harvest.context.ProcessorContext;

/**
 * Created by hongkai on 2017/9/26.
 */
public class DefaultProcessorChain implements ProcessorChain {

    private Processor processor;

    private Processor nextProcessor;

    private ProcessorChain nextProcessorChain;

    public DefaultProcessorChain(Processor processor, Processor nextProcessor) {
        this.processor = processor;
        this.nextProcessor = nextProcessor;
    }

    public void doProcess(ProcessorContext context){
        if(nextProcessor != null){
            if(context.isSkipOtherProcessor()){
                ProcessorChainRegistry.LAST_PROCESSOR_CHAIN.doProcess(context);
            } else {
                nextProcessor.process(context, nextProcessorChain);
            }
        }
    }

    public void setNextProcessorChain(ProcessorChain nextProcessorChain) {
        this.nextProcessorChain = nextProcessorChain;
    }

    public Processor getProcessor() {
        return processor;
    }
}
