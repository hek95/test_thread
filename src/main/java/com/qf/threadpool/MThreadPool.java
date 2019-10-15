package com.qf.threadpool;

import com.qf.threadsynchronization.MyRunable2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ExecutorService 线程接口
 * Executors 创建各种线程的工具类
 * new SingleThreadExecutor()创建单个线程对象的线程池 串行执行所有的任务 如果这个线程因为异常结束那么会有
 * 一个新的线程来代替它
 * new FixedThreadExecutor() 创建固定大小的线程池 每次提交一个任务就创建一个线程 直到线程池中的线程对象达到最大值
 *new CachedThreadpool() 创建一个可缓存的线程池。如果线程池的大小超过了处理任务所需要的线程，那
 *  么就会回收部分空闲（60秒不执行任务）的线程，当任务数增加时，此线程池又
 *  可以智能的添加新线程来处理任务。此线程池不会对线程池大小做限制，线程池
 *  大小完全依赖于操作系统（或者说JVM）能够创建的最大线程大小
 *
 */
public class MThreadPool  {
    public static void main(String[] args) {
        //创建线程池对象
        //ExecutorService pool1=Executors.newSingleThreadExecutor();
        //ExecutorService pool1=Executors.newFixedThreadPool(2);
        ExecutorService pool1= Executors.newCachedThreadPool();

        //创建任务对象
        MyRunable2 mr1=new MyRunable2();
        MyRunable2 mr2=new MyRunable2();
        MyRunable2 mr3=new MyRunable2();

        //从线程池中取出线程对象执行任务
        pool1.submit(mr1);
        pool1.submit(mr2);
        pool1.submit(mr3);

        //关闭线程池
        pool1.shutdown();
    }
}
