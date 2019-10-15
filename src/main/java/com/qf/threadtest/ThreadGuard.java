package com.qf.threadtest;
//守护线程 守护非守护的的线程 一旦进程中所有的非守护线程都死亡了 守护线程也就死亡了
//设置当前的线程为守护线程 线程对象.setDaemon(true)
public class ThreadGuard  extends Thread {
    @Override
    public void run() {
        for(int i=1;i<1000;i++){
            System.out.println(this.getName()+":"+i);
        }
    }

    public static void main(String[] args) {
        //创建线程对象
        ThreadGuard tg1=new ThreadGuard();
        tg1.setName("守护线程");
        //设置当前的线程为守护线程
        tg1.setDaemon(true);
        //启动线程
        tg1.start();
      for(int i=1; i<10;i++){
          System.out.println("主线程:"+i);
      }
    }
}
