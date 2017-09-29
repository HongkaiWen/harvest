package com.github.hongkaiwen.harvest.action;

import com.github.hongkaiwen.harvest.util.HarvestFileUtils;
import org.apache.commons.io.FileExistsException;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

/**
 * Created by hongkai on 2017/9/29.
 */
public class MoveAction implements Action {

    private static final Logger logger = LoggerFactory.getLogger(MoveAction.class);

    private File source;

    private File target;

    public MoveAction(File source, File target) {
        this.source = source;
        this.target = target;
    }

    @Override
    public void action() {
        try {
            FileUtils.moveFileToDirectory(source, target, true);
        } catch (FileExistsException fileExistsException) {
            File newTarget = HarvestFileUtils.appendTimeStamp(source, target);
            try {
                FileUtils.moveFile(source, newTarget);
            } catch (IOException e) {
                logger.error(String.format("move file error, src %s, target %s", source.toString(), target.toString()));
                logger.error("move file error", e);
            }
        } catch (IOException e) {
            logger.error(String.format("move file error, src %s, target %s", source.toString(), target.toString()));
            logger.error("move file error", e);
        }
    }
}
