package com.efostach.ata.service;

public class TaskDecorator implements Runnable {

    private Runnable runnable;

    public TaskDecorator(Runnable runnable) {
        this.runnable = runnable;
    }

    @Override
    public void run() {
        runnable.run();
    }
}
