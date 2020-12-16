package com.example.concurrent.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * 计数线程
 *
 * @author liugang
 * @create 2020/12/16
 */
public class CountDownThread implements Runnable {

    private CountDownLatch countDownLatch;

    public CountDownThread(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println("Task Start, countDownLatch:" + countDownLatch.getCount());
        this.doCountDown();
        System.out.println("Task End, countDownLatch:" + countDownLatch.getCount());
    }

    private void doCountDown() {
        try {
            Thread.sleep(1000 * 2);
            countDownLatch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
