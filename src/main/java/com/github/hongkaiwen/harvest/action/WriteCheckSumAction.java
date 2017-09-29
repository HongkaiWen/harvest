package com.github.hongkaiwen.harvest.action;

import java.io.File;

/**
 * Created by hongkai on 2017/9/27.
 */
public class WriteCheckSumAction implements Action {

    private File file;

    public WriteCheckSumAction(File file) {
        this.file = file;
    }

    @Override
    public void action() {

    }
}
