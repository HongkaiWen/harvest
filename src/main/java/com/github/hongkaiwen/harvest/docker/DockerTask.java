package com.github.hongkaiwen.harvest.docker;

import com.github.hongkaiwen.harvest.BootApplication;
import com.github.hongkaiwen.harvest.action.Action;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by hongkai on 2017/9/30.
 */
public class DockerTask implements Runnable {

    private static final Logger logger = LoggerFactory.getLogger(DockerTask.class);

    private Action[] actions;

    public DockerTask(Action... action) {
        this.actions = action;
    }

    @Override
    public void run() {
        for (Action action : actions) {
            action.action();
        }
        long done = BootApplication.doneFiles.incrementAndGet();
        logger.info(String.format("processing ... (%d/%d)", done, BootApplication.filesCount));
    }
}
