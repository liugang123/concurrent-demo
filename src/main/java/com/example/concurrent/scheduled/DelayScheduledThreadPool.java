package com.example.concurrent.scheduled;

import java.util.Date;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 计划执行线程池
 * <p>
 * 1.延迟执行任务
 * 2.定时执行任务
 *
 * @author liugang
 * @create 2020/12/16
 */
public class DelayScheduledThreadPool {

    public static void main(String[] args) {
        // 1.创建线程池
        ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(5);
        System.out.println("Current Time = " + new Date());
        // 2.线程池启动任务
        for (int i = 0; i < 10; i++) {
            ScheduledWorkTask workTask = new ScheduledWorkTask(String.valueOf(i));
            // 延迟10s执行
            executorService.schedule(workTask, 10, TimeUnit.SECONDS);
        }
        // 3.关闭线程池
        executorService.shutdown();
        // 4.等待任务执行完毕
        while (!executorService.isTerminated()) {
        }
        // 5.任务执行完毕
        System.out.println("Scheduled Execute Finished");
    }
}
