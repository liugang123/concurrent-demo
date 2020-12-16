package com.example.concurrent.countdownlatch;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

/**
 * 有返回值的执行任务
 *
 * @author liugang
 * @create 2020/12/16
 */
public class CountDownFutureThread implements Callable<String> {

    private CountDownLatch countDownLatch;

    private Integer taskId;

    public CountDownFutureThread(CountDownLatch countDownLatch, Integer taskId) {
        this.countDownLatch = countDownLatch;
        this.taskId = taskId;
    }

    @Override
    public String call() throws Exception {
        return this.doTask(countDownLatch, taskId);
    }

    private String doTask(CountDownLatch countDownLatch, Integer taskId) {
        System.out.println("DoTask getCount():" + countDownLatch.getCount());
        countDownLatch.countDown();
        return "task" + taskId;
    }
}
