package com.qf.threadtest;
//设置线程的优先级
//优先级越高的线程抢占时间碎片的概率越高  设置线程的优先级一定要在线程启动之前设置才有效 只是概率会高
public class ThreadProx {
    public static void main(String[] args) {
        //创建线程对象
        MyThread t1=new MyThread();
        MyThread t2=new MyThread();
        //调用方法给线程取名
        t1.setName("线程1");
        t2.setName("线程2");
        //设置线程的优先级
        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);
        //开启线程
        t1.start();
        t2.start();
    }
}
