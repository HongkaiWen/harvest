package com.github.hongkaiwen.harvest.docker;

import com.github.hongkaiwen.harvest.BootApplication;
import com.github.hongkaiwen.harvest.action.Action;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by hongkai on 2017/9/30.
 */
public class DockerTask implements Runnable {

    private static final Logger logger = LoggerFactory.getLogger(DockerTask.class);

    private List<Action> actionList;

    public DockerTask(List<Action> actionList) {
        this.actionList = actionList;
    }

    @Override
    public void run() {
        for (Action action : actionList) {
            action.action();
        }
        long done = BootApplication.doneFiles.incrementAndGet();
        logger.info(String.format("processing ... (%d/%d)", done, BootApplication.filesCount));
    }
}
