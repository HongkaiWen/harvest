package com.github.hongkaiwen.harvest.processor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hongkai on 2017/9/26.
 */
public enum  ProcessorRegistry {

    INSTANCE;

    private List<Processor> registry = new ArrayList<>();

    public void registry(Processor processor){
        registry.add(processor);
    }

    public List<Processor> getRegistry() {
        return registry;
    }
}
