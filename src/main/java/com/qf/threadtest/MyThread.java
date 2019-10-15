package com.qf.threadtest;

//第一种实现线程的方式
/*
声名一个自定义类让其继承Thread类重写run方法 实现线程类  各个线程互抢资源 来执行run方法直至每个线程把
run方法中的任务全部执行完
 */
public class MyThread extends Thread{
    @Override
    public void run() {
        for(int i=1;i<=10;i++){
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }

    public static void main(String[] args) {
        //创建线程对象
        MyThread t1=new MyThread();
        MyThread t2=new MyThread();
        //调用线程方法给线程取名
        t1.setName("线程1");
        t2.setName("线程2");
        //启动线程
        t1.start();
        t2.start();
    }
}
