package com.example.leetcode.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: lichengcan
 * @email ccnaive@qq.com
 * @date: 2024-02-23 17:55
 * @description ThreadLocal用来存储线程状态相关的状态信息，每一个线程都有独立的ThreadLocal，与其他线程的互不干扰
 **/
public class ThreadLocalTest {
    // 定义一个ThreadLocal变量，用来保存每个线程的特定数据
    public static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    public static void main(String[] args) {
        // 创建一个固定大小的线程池
        ExecutorService executor = Executors.newFixedThreadPool(5);
        // 提交任务到线程池
        for (int i = 0; i < 5; i++) {
            final int taskId = i;
            executor.submit(() -> {
                // 每个线程开始时设置自己的ThreadLocal值
                threadLocal.set("Task ID: " + taskId);
                // 执行任务并访问当前线程的ThreadLocal变量
                doSomeWork();
                // 在任务结束后清除ThreadLocal中的值（避免内存泄漏）
                threadLocal.remove();
            });
        }
        // 关闭线程池
        executor.shutdown();
    }

    // 模拟执行一些工作，在其中需要访问线程局部变量
    private static void doSomeWork() {
        String taskInfo = threadLocal.get();
        System.out.println("Thread ID: " + Thread.currentThread().getId() + ", Task Info: " + taskInfo);
        // 假设在此处进行基于taskInfo的任务操作
    }
}
