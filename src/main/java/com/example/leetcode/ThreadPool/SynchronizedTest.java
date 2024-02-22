package com.example.leetcode.ThreadPool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: lichengcan
 * @email ccnaive@qq.com
 * @date: 2024-02-22 16:58
 * @description
 **/
public class SynchronizedTest {

    private static int count;
    private static synchronized void increment(){
        count++;
    }

    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(10, 20,20, TimeUnit.SECONDS,new LinkedBlockingQueue<>());
        for (int i = 10; i > 0; i--) {
            pool.execute(()->{
                for (int j = 10; j > 0; j--) {
                    increment();
                    synchronized (SynchronizedTest.class) {
                        System.out.println("count = " + count);
                    }
                }
            });
        }
    }
}
