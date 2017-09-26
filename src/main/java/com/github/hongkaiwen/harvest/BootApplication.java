package com.github.hongkaiwen.harvest;


import com.github.hongkaiwen.harvest.processor.ProcessorEntry;

/**
 * Created by hongkai on 2017/8/28.
 */
public class BootApplication {

    public static void main(String args[]){
        ProcessorEntry.INSTANCE.run();
    }

    

}
