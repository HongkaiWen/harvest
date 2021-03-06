package com.github.hongkaiwen.harvest;


import com.github.hongkaiwen.harvest.processor.ProcessorEntry;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by hongkai on 2017/8/28.
 */
public class BootApplication {

    public static final Date CURRENT_TIME = new Date();

    public static int filesCount;

    public static AtomicLong doneFiles = new AtomicLong(0);

    public static AtomicInteger addFiles = new AtomicInteger(0);

    public static void main(String args[]){
        ProcessorEntry.INSTANCE.run();
    }

    

}
