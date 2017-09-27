package com.github.hongkaiwen.harvest.processor;

import com.github.hongkaiwen.harvest.MediaFilter;
import com.github.hongkaiwen.harvest.constants.CommonConstants;
import com.github.hongkaiwen.harvest.context.ProcessorContext;
import com.github.hongkaiwen.harvest.processor.impl.FileCheckSumProcessor;
import com.github.hongkaiwen.harvest.processor.impl.FileNameProcessor;
import com.github.hongkaiwen.harvest.processor.impl.MediaCreateTimeProcessor;
import com.github.hongkaiwen.harvest.service.FileService;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by hongkai on 2017/9/26.
 */
public enum ProcessorEntry {
    INSTANCE;


    private void init(){
        ProcessorRegistry.INSTANCE.registry(new FileCheckSumProcessor());
        ProcessorRegistry.INSTANCE.registry(new MediaCreateTimeProcessor());
        ProcessorRegistry.INSTANCE.registry(new FileNameProcessor());
        if(ProcessorRegistry.INSTANCE.getRegistry().size() == 0){
            throw new RuntimeException("no processor! nothing to do.");
        }
        ProcessorChainRegistry.INSTANCE.init();
    }

    public void run(){
        System.out.println("application starting up...");
        init();
        System.out.println("application starting up done!");

        List<File> files = FileService.INSTANCE.listRecursive(new File(CommonConstants.STAGE), new MediaFilter());
        List<ProcessorContext> contexts = files.stream().map(file -> new ProcessorContext(file)).collect(Collectors.toList());
        contexts.stream().forEach(context -> {
            List<ProcessorChain> registry = ProcessorChainRegistry.INSTANCE.getRegistry();
            DefaultProcessorChain processorChain = (DefaultProcessorChain) registry.get(0);
            processorChain.getProcessor().process(context, processorChain);
        });

        System.out.println("application execute finished!");
    }
}
