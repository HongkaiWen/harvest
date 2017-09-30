package com.github.hongkaiwen.harvest.action;

import com.github.hongkaiwen.harvest.constants.FilePath;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

/**
 * Created by hongkai on 2017/9/27.
 */
public class WriteCheckSumAction implements Action {

    private static final Logger logger = LoggerFactory.getLogger(WriteCheckSumAction.class);

    private String repositoryFile;

    private String checkSum;

    public WriteCheckSumAction(String targetPath, String checkSum) {
        this.repositoryFile = targetPath;
        this.checkSum = checkSum;
    }

    @Override
    public void action() {
        File checkSumFile = new File(String.format("%s/%s.DAT", FilePath.getDataPath(), checkSum));
        try {
            FileUtils.writeStringToFile(checkSumFile, repositoryFile);
        } catch (IOException e) {
            logger.error("IMPORTANT: write repository file checkSum info failed!! " + repositoryFile, e);
        }
    }
}
