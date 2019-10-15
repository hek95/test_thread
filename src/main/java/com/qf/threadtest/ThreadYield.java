package com.qf.threadtest;
//线程礼让
//暂停正在执行的线程对象 并执行其他线程
public class ThreadYield extends Thread {
    @Override
    public void run() {
        for(int i=1;i<20;i++){
            System.out.println(Thread.currentThread().getName()+":"+i);
            //如果当前线程是B就礼让一次
            if(Thread.currentThread().getName().equals("线程B")){
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) {
        //创建线程对象
        ThreadYield ty1=new ThreadYield();
        ThreadYield ty2=new ThreadYield();
        //给线程取名字
        ty1.setName("线程A");
        ty2.setName("线程B");
        ty1.start();
        ty2.start();
    }
}
