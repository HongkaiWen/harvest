package com.github.hongkaiwen.harvest.action;

import java.io.File;

/**
 * Created by hongkai on 2017/9/27.
 */
public class CopyAction implements Action {

    private File source;

    private File target;

    public CopyAction(File source, File target) {
        this.source = source;
        this.target = target;
    }

    @Override
    public void action() {

    }
}
