package com.qf.threadsynchronization;
//对象互斥锁

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 锁的范围越小越好
 * 对象互斥锁确保在任何情况下解锁 防止死锁
 */
public class MyRunable4 implements Runnable {
   //票的成员变量
    public int ticket=1000;
    /**
     * 声名对象互斥锁对象
     */
    Lock lo=new ReentrantLock();

    /**
     * 任务方法
     */
    public void run() {
     while(true){
         try{
             //上锁
             lo.lock();
             if(ticket>0){
                 System.out.println(Thread.currentThread().getName()+"正在销售"+ticket+"张票");
                 ticket--;
             }else{
                 break;
             }
         }finally {
             //解锁
             lo.unlock();
         }
     }
     System.out.println("票已售完！");
    }

    public static void main(String[] args) {
        //创建任务对象
        MyRunable4 mr4=new MyRunable4();
        for(int i=0;i<10;i++){
            //创建线程对象

            if(i==10){
                Thread t1=new Thread(mr4);
                t1.setName("窗口0"+i);
                t1.start();
            }else{
                Thread t1=new Thread(mr4);
                t1.setName("窗口00"+i);
                t1.start();
            }
        }
    }

}
