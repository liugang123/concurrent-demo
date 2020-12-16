package com.example.concurrent.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 任务管理类
 *
 * @author liugang
 * @create 2020/12/15
 */
public class TaskManager {

    public static void main(String[] args) {
        // 1.配置线程池
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,
                5,
                10,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(4),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());
        // 2.监控线程池
        ThreadPoolMinitorTask minitorTask = new ThreadPoolMinitorTask(executor, 3);
        Thread minitorThread = new Thread(minitorTask);
        minitorThread.start();
        // 3.启动任务
        try {
            int taskCount = 20;
            for (int i = 0; i < taskCount; i++) {
                TaskExecutor taskExecutor = new TaskExecutor(i);
                executor.execute(taskExecutor);
            }
        } finally {
            executor.shutdown();
        }
        // 4.关闭线程池，停止接受新任务，将现有任务队列执行完毕
        executor.shutdown();
    }
}
