package com.qf.threadtest;
//用变量做标记中断线程
public class ThreadFlag extends  Thread {
    //声名一个变量做标记 标记是否中断线程
    public boolean flag=false;

    @Override
    public void run() {
        for(int i=0;i<=200;i++){
            if(flag){
                break;
            }
            System.out.println(this.getName()+":"+i);

        }
    }

    public static void main(String[] args) throws InterruptedException {
        //创建 线程对象
        ThreadFlag tf1=new ThreadFlag();
        //给线程取名
        tf1.setName("子线程A");
        tf1.start();
        for(int i=0;i<=200;i++){
            System.out.println("主线程"+i);
            //当主线程运行到10的时候 改变子线程的中断状态
            if(i==10){
                tf1.flag=true;
                Thread.sleep(2000);
            }
        }
    }
}
