package com.qf.threadtest;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

//第三种实现线程的方法 自定义一个类 让其实现callable接口 重写 call方法 线程之间互抢资源 直至每个线程将 call中的任务执行完
public class MyCallable implements Callable {
    public Object call() {
        for(int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
        return null;
    }

    public static void main(String[] args) {
      //创建MyCallable对象
      MyCallable m1=new MyCallable();
      MyCallable m2=new MyCallable();
      //将其封装成任务对象
        FutureTask f1=new FutureTask(m1);
        FutureTask f2=new FutureTask(m2);
        //将其进一步的封装成线程对象
        Thread t1=new Thread(f1,"线程C");
        Thread t2=new Thread(f2,"线程D");
        //开启线程
        t1.start();
        t2.start();

    }
}
