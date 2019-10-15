package com.qf.threadtest;
//线程中断
public class ThreadInterrupted extends Thread {
    @Override
    public void run() {
        for(int i=1;i<=200;i++){
            //当子线程的中断状态为true时跳出循环
            if(this.isInterrupted()==true){
                break;
            }
            System.out.println(this.getName()+":"+i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadInterrupted ti1=new ThreadInterrupted();
        //给线程取名
        ti1.setName("子线程");
        //启动线程
        ti1.start();
        for(int i=0;i<200;i++){
            System.out.println("主线程："+i);
            //当主线程运行到10 改变子线程的中断状态
            if(i==10){
                ti1.isInterrupted();
                //主线程休眠2000秒
                Thread.sleep(2000);
            }
        }
    }
}
