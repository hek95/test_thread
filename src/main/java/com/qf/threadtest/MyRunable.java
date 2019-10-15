package com.qf.threadtest;
/*
第二种实现线程的方法  自定义一个类让其实现Runable接口 重写run方法 线程之间互抢资源共同完成run方法中的任务
 */
public class MyRunable implements Runnable {
    public void run() {
       for(int i=0;i<10;i++){
           System.out.println(Thread.currentThread().getName()+":"+i);
       }
    }

    public static void main(String[] args) {
        //创建任务对象
        MyRunable m1=new MyRunable();
        MyRunable m2=new MyRunable();
        //将任务对象封装成线程对象
        Thread t1=new Thread(m1,"线程A");
        Thread t2=new Thread(m2,"线程B");
        //启动线程
        t1.start();
        t2.start();
    }
}
