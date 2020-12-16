package com.example.concurrent.scheduled;

import java.util.Date;

/**
 * 工作线程
 *
 * @author liugang
 * @create 2020/12/16
 */
public class ScheduledWorkTask implements Runnable {

    private String command;

    public ScheduledWorkTask(String command) {
        this.command = command;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start.Time = " + new Date());
        this.processCommand();
        System.out.println(Thread.currentThread().getName() + " End.Time = " + new Date());
    }

    private void processCommand() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
