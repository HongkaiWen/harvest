package com.github.hongkaiwen.harvest.context;


import com.github.hongkaiwen.harvest.action.Action;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hongkai on 2017/9/26.
 */
public class ProcessorContext {

    public ProcessorContext(File sourceFile) {
        this.sourceFile = sourceFile;
        this.actionList = new ArrayList<>();
    }

    private File sourceFile;

    private List<Action> actionList;

    private boolean skipOtherProcessor;

    private FileInfo fileInfo = new FileInfo();

    public File getSourceFile() {
        return sourceFile;
    }

    public void setSourceFile(File sourceFile) {
        this.sourceFile = sourceFile;
    }

    public List<Action> getActionList() {
        return actionList;
    }

    public void setActionList(List<Action> actionList) {
        this.actionList = actionList;
    }

    public FileInfo getFileInfo() {
        return fileInfo;
    }

    public void setFileInfo(FileInfo fileInfo) {
        this.fileInfo = fileInfo;
    }

    public boolean isSkipOtherProcessor() {
        return skipOtherProcessor;
    }

    public void setSkipOtherProcessor(boolean skipOtherProcessor) {
        this.skipOtherProcessor = skipOtherProcessor;
    }
}
