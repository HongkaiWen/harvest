package com.github.hongkaiwen.harvest;


import com.github.hongkaiwen.harvest.processor.ProcessorEntry;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by hongkai on 2017/8/28.
 */
public class BootApplication {

    public static final Date CURRENT_TIME = new Date();

    public static AtomicLong taskCount = new AtomicLong(0);

    public static AtomicLong doneTask = new AtomicLong(0);

    public static void main(String args[]){
        ProcessorEntry.INSTANCE.run();
    }

    

}
