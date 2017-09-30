package com.github.hongkaiwen.harvest.docker;

import java.util.concurrent.*;

/**
 * Created by hongkai on 2017/9/30.
 */
public class DockerPool {
    public static final ExecutorService executor =  new ThreadPoolExecutor(0, 10,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>());
}
