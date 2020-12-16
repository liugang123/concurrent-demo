package com.example.concurrent.countdownlatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 具有返回值的任务执行
 *
 * @author liugang
 * @create 2020/12/16
 */
public class CountDownFutureManager {

    public static void main(String[] args) {
        // 1.创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        // 任务总数
        int taskCount = 10;
        // 2.创建计数器
        CountDownLatch countDownLatch = new CountDownLatch(taskCount);
        // 3.执行任务
        List<Future<String>> futureList = new ArrayList<>();
        for (int i = 0; i < taskCount; i++) {
            CountDownFutureThread futureThread = new CountDownFutureThread(countDownLatch, i);
            Future<String> future = executorService.submit(futureThread);
            futureList.add(future);
        }
        // 4.等待任务执行完成
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 5.结果数据
        List<String> result = new ArrayList<>();
        for (Future<String> future : futureList) {
            try {
                result.add(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println(result.toString());
        // 6.关闭线程池
        executorService.shutdown();
    }
}
