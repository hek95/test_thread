package com.qf.threadtest;
//线程合并 让多个线程合并到一个线程 先执行完合并过来的线程 再执行原来的线程
//使用 线程对象.join()
public class ThreadJoin extends Thread {
    @Override
    public void run() {
        for(int i=0;i<=50;i++){
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //创建一个子线程对象
        ThreadJoin t1=new ThreadJoin();
        t1.setName("子线程");
        //启动子线程
        t1.start();
        for(int i=0;i<=50;i++){
            System.out.println("主线程"+i);
           //当主线程运行到10时 子线程合并到主线程
            if(i==10){
                t1.join();
            }
        }

    }
}
