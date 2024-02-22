package com.example.leetcode.ThreadPool;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    public static void main(String[] args) {
        for (int j = 10; j > 0; j--) {
            new Thread(() -> {
                for (int i = 10; i > 0; i--) {
                    lock.lock();
                    //这里的新增和打印需要看成一个整体，如果分开加锁，就还是会有问题呀
                    //比如我++了，然后释放了++锁，还没来得及打印，别的线程也开始++
                    try {
                        increment();
                        sout();
                    } finally {
                        lock.unlock();
                    }
                }
            }).start();
        }
    }

    static int count = 0;
    static Lock lock = new ReentrantLock();

    public static void increment() {
        count++;
    }

    public static void sout() {
        System.out.println("count = " + count);
    }
}
