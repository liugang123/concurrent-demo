package com.example.concurrent.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 计数器管理
 *
 * @author liugang
 * @create 2020/12/16
 */
public class CountDownLatchManager {

    public static void main(String[] args) {
        // 1.初始化线程池
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        // 2.设置计数器
        int taskCount = 10;
        CountDownLatch countDownLatch = new CountDownLatch(taskCount);
        // 3.执行任务
        for (int i = 0; i < taskCount; i++) {
            // 执行任务
            CountDownThread countDownThread = new CountDownThread(countDownLatch);
            executorService.execute(countDownThread);
        }
        // 4.唤醒主线程
        try {
            System.out.println("Wait All Task Run");
            countDownLatch.await();
            System.out.println("All Task Finished");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 5.关闭线程池
            executorService.shutdown();
        }
    }

}
