package com.qf.threadsynchronization;

/**
 * 为什么要线程同步？
 * 临界资源问题
 * 临界资源： 同一个进程中多个线程共享的资源
 * 临界资源问题 ：在一个进程中一个线程获得cpu时间片 运行共享资源 来没来的及修改共享资源 就被另一个线程将
 * cpu时间片抢过去运行还没来得及修改的共享资源就会出现临界资源问题
 * 解决临界资源问题的方法就是实现线程同步
 * 将要一起执行的代码绑定在一块形成代码块 当一个线程抢到cpu时间片进入这个代码中执行时 其他线程就不能进入该代码快中执行
 * 只有当其他线程抢到cpu时间片且该代码块中没有线程执行时 才能进去执行代码
 */
//同步代码块实现线程同步 锁的范围越小越好
    //锁对象：只要是多线程共享的一个对象 都可以作为锁对象 锁对象的值一般是不变的
public class MyRunable2 implements  Runnable {
    /**
     * 票数的成员变量
     */
    public int ticket = 100;
    //声名一个对象作为锁对象
    Object ob = new Object();


    public void run() {
        while (true) { //死循环
            synchronized (ob) {
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "正在销售第" + ticket + "张票");
                    ticket--;
                } else {
                    break;
                }
            }
        }
        System.out.println("票已售完！");
    }

    public static void main(String[] args) {
        //创建任务对象
        MyRunable2 mr1 = new MyRunable2();
        //创建十个线程对象  10个线程对象共享一个任务对象
        for (int i = 1; i <= 10; i++) {
            if (i == 10) {
                Thread t1 = new Thread(mr1);
                t1.setName("窗口0" + i);
                //开启线程
                t1.start();
            } else {
                Thread t1 = new Thread(mr1);
                t1.setName("窗口00" + i);
                //开启线程
                t1.start();
            }
        }
    }
}
