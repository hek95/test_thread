package com.qf.threadsynchronization;

/**
 * 同步方法实现线程同步
 *
 */
public class MyRunable3 implements Runnable {
    //票数的成员变量
    public int ticket = 100;

    /**
     * 声名一个对象作为锁对象
     */
    Object ob = new Object();

    public void run() {
        while (true) {
            if (saleTicket()== true) {
                break;
            }
        }
        System.out.println("票已售完！");
    }

    //同步方法
    public synchronized boolean saleTicket() {
        while (true) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "正在销售第" + ticket + "张票");
                ticket--;
                return false;
            } else {
                return true;
            }
        }

    }

    public static void main(String[] args) {
        //创建任务对象
        MyRunable3 mr3 = new MyRunable3();
        //创建十个线程对象  十个线程对象共享一个任务对象
        for (int i = 0; i < 10; i++) {
            Thread t1 = new Thread(mr3);
            //设置线程名称
            if (i == 10) {
                t1.setName("窗口0" + i);
                t1.start();
            } else {
                t1.setName("窗口00" + i);
                t1.start();
            }
        }
    }
}