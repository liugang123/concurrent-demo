package com.example.concurrent.executor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * 线程池监控任务类
 *
 * @author liugang
 * @create 2020/12/15
 */
public class ThreadPoolMinitorTask implements Runnable {

    private ThreadPoolExecutor executor;

    // 监控采集时间间隔
    private Integer interval;

    // 监控状态
    private boolean running;

    public ThreadPoolMinitorTask(ThreadPoolExecutor executor, Integer interval) {
        this.executor = executor;
        this.interval = interval;
        // 开启监控
        this.running = true;
    }

    /**
     * 执行任务
     */
    @Override
    public void run() {

        while (running) {
            System.out.println("======== Run Minitor Task ==========");

            StringBuilder sBuilder = new StringBuilder();
            sBuilder.append("corePoolSize:").append(executor.getCorePoolSize());
            sBuilder.append(";maxPoolSize:").append(executor.getMaximumPoolSize());
            //sBuilder.append(";keepAliveTime:").append(executor.getKeepAliveTime(TimeUnit.SECONDS));
            //sBuilder.append(";rejectedPolicy:").append(executor.getRejectedExecutionHandler());
            sBuilder.append(";activeCount:").append(executor.getActiveCount());
            sBuilder.append(";completedTaskCount:").append(executor.getCompletedTaskCount());
            sBuilder.append(";queueSize:").append(executor.getQueue().size());

            System.out.println(sBuilder.toString());
            System.out.println("========= Minitor Task Finish ============");

            // 间隔时间
            try {
                Thread.sleep(1000 * interval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 停止监控
     */
    public void shutdown() {
        this.running = false;
    }
}
