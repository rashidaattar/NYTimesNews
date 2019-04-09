package com.demo.nytimesnews.base.utils;

import io.reactivex.Scheduler;

/**
 * Created by Rashida on 4/8/19.
 */
public interface SchedulerProvider {
    Scheduler io();

    Scheduler ui();

    Scheduler computation();

    void triggerActions();
}
