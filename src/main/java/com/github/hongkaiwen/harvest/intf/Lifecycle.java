package com.github.hongkaiwen.harvest.intf;

/**
 * Created by hongkai on 2017/9/29.
 */
public interface Lifecycle {

    default void init(){}

    default void destroy(){}
}
