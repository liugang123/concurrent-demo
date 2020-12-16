package com.example.concurrent.scheduled;

import java.util.Date;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 定时执行任务
 *
 * @author liugang
 * @create 2020/12/16
 */
public class PeriodScheduledThreadPool {

    public static void main(String[] args) {
        // 1.创建线程池
        ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(2);
        // 2.定时执行任务
        System.out.println("Current Time:" + new Date());
        for (int i = 0; i < 10; i++) {
            ScheduledWorkTask workTask = new ScheduledWorkTask("task" + i);
            // 任务执行时间大于间隔时间，会等待任务执行完毕后，在次执行，相当于连续执行
            executorService.scheduleAtFixedRate(workTask, 0, 5, TimeUnit.SECONDS);
        }
        // 3.关闭线程池
        // executorService.shutdown();
        // 4.等待线程池关闭
        while (!executorService.isTerminated()) {
        }
        System.out.println("Scheduled execute finished");
    }
}
