package com.github.hongkaiwen.harvest.processor;

import com.github.hongkaiwen.harvest.BootApplication;
import com.github.hongkaiwen.harvest.MediaFilter;
import com.github.hongkaiwen.harvest.constants.CommonConstants;
import com.github.hongkaiwen.harvest.context.ProcessorContext;
import com.github.hongkaiwen.harvest.processor.impl.*;
import com.github.hongkaiwen.harvest.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by hongkai on 2017/9/26.
 */
public enum ProcessorEntry {

    INSTANCE;

    private static final Logger logger = LoggerFactory.getLogger(ProcessorEntry.class);

    private void init(){
        ProcessorRegistry.INSTANCE.registry(new FileCheckSumProcessor());
        ProcessorRegistry.INSTANCE.registry(new FileTypeProcessor());
        ProcessorRegistry.INSTANCE.registry(new MediaCreateTimeProcessor());
        ProcessorRegistry.INSTANCE.registry(new UnrecognizedProcessor());
        ProcessorRegistry.INSTANCE.registry(new FileNameProcessor());
        ProcessorRegistry.INSTANCE.registry(new SourceFilesDuplicateCheckProcessor());
        ProcessorRegistry.INSTANCE.registry(new DuplicateByRepositoryCheckProcessor());
        ProcessorRegistry.INSTANCE.registry(new Move2RepositoryProcessor());
        if(ProcessorRegistry.INSTANCE.getRegistry().size() == 0){
            throw new RuntimeException("no processor! nothing to do.");
        }
        initInternal();
    }

    private void initInternal(){
        ProcessorRegistry.INSTANCE.getRegistry().forEach(processor -> processor.init());
        ProcessorChainRegistry.INSTANCE.init();
    }

    private void destroy(){
        ProcessorRegistry.INSTANCE.getRegistry().forEach(processor -> processor.destroy());
    }

    public void run(){
        try{
            init();

            List<File> files = FileService.INSTANCE.listRecursive(new File(CommonConstants.STAGE), new MediaFilter());
            BootApplication.filesCount = files.size();
            logger.info(String.format("%d files to be moved", BootApplication.filesCount));
            List<ProcessorContext> contexts = files.stream().map(file -> new ProcessorContext(file)).collect(Collectors.toList());
            contexts.stream().parallel().forEach(context -> {
                List<ProcessorChain> registry = ProcessorChainRegistry.INSTANCE.getRegistry();
                DefaultProcessorChain processorChain = (DefaultProcessorChain) registry.get(0);
                processorChain.getProcessor().process(context, processorChain);
            });

            logger.info(String.format("application finished, %d files added!", BootApplication.addFiles.get()));
        }finally {
            destroy();
        }
    }
}
