package com.github.hongkaiwen.harvest.operate;

import java.io.File;

/**
 * Created by hongkai on 2017/9/26.
 */
public class Action {

    private ActionType actionType;

    private File sourceFile;

    private File targetFile;



    public ActionType getActionType() {
        return actionType;
    }

    public void setActionType(ActionType actionType) {
        this.actionType = actionType;
    }

    public File getSourceFile() {
        return sourceFile;
    }

    public void setSourceFile(File sourceFile) {
        this.sourceFile = sourceFile;
    }

    public File getTargetFile() {
        return targetFile;
    }

    public void setTargetFile(File targetFile) {
        this.targetFile = targetFile;
    }

    @Override
    public String toString() {
        return "Action{" +
                "actionType=" + actionType +
                ", sourceFile=" + sourceFile +
                ", targetFile=" + targetFile +
                '}';
    }
}
