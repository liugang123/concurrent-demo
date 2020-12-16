package com.example.concurrent.executor;

/**
 * 任务执行内容
 *
 * @author liugang
 * @create 2020/12/15
 */
public class TaskExecutor implements Runnable {

    private Integer taskId;

    public TaskExecutor(Integer taskId) {
        this.taskId = taskId;
    }

    /**
     * 任务执行
     */
    @Override
    public void run() {
        System.out.println("TaskExecutor Start，taskId：" + taskId);
        this.doTask();
        System.out.println("TaskExecutor End，taskId：" + taskId);
    }

    private void doTask() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
