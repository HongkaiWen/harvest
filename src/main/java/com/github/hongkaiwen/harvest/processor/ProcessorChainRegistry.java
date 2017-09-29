package com.github.hongkaiwen.harvest.processor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hongkai on 2017/9/26.
 */
public enum  ProcessorChainRegistry {

    INSTANCE;

    private List<ProcessorChain> registry = new ArrayList<>();

    public List<ProcessorChain> getRegistry() {
        return registry;
    }

    public static final LastProcessorChain LAST_PROCESSOR_CHAIN = new LastProcessorChain();

    public void init(){
        List<Processor> registry = ProcessorRegistry.INSTANCE.getRegistry();
        if(registry == null || registry.size() == 0){
            return;
        }

        Processor first = registry.get(0);
        Processor pre = first;
        if(registry.size() > 1){
            for(int i=1; i<registry.size(); i++){
                this.registry.add(new DefaultProcessorChain(pre, registry.get(i)));
                pre = registry.get(i);
            }
        } else {
            this.registry.add(new DefaultProcessorChain(first, null));
        }

        DefaultProcessorChain last = (DefaultProcessorChain) this.registry.get(this.registry.size() -1);
        last.setNextProcessorChain(LAST_PROCESSOR_CHAIN);
        ProcessorChain preChain = last;
        if(this.registry.size() > 1){
            for(int i = this.registry.size() -2; i >=0; i--){
                ((DefaultProcessorChain)this.registry.get(i)).setNextProcessorChain(preChain);
                preChain = this.registry.get(i);
            }
        }
    }
}
