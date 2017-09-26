package com.github.hongkaiwen.harvest.service;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hongkai on 2017/9/26.
 */
public enum FileService {
    INSTANCE;

    /**
     * 递归遍历文件
     *
     * @param root
     * @param filter
     * @return
     */
    public List<File> listRecursive(File root, FileFilter filter) {
        List<File> result = new ArrayList<>();
        if (root.isFile()) {
            result.add(root);
            return result;
        }
        for (File file : root.listFiles()) {
            if (file.isFile()) {
                if (filter != null) {
                    if (filter.accept(file))
                        result.add(file);
                } else {
                    result.add(file);
                }
            } else {
                result.addAll(listRecursive(file, filter));
            }
        }
        return result;
    }
}
