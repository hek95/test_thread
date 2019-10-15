package com.qf.threadtest;
//线程休眠  让当前线程在休眠期让出cpu时间片 不参加抢占 一旦休眠时间到了 当前线程重新参与cpu时间片抢占
//使用 Thread.sleep(long millis)  或者线程对象.sleep(long millies)
public class ThreadSleep  {
    public static void main(String[] args) throws InterruptedException {
        //声名一个数组存取六名学员的姓名
        String[]sname= {"张三","李四","王五","赵六","钱七","谢八"};
        //生成0-5的随机数作为抽取学员的下标
        int r= (int)(Math.random()*6);
        for(int i=3;i>=0;i--){
            //当前线程睡眠一秒
            Thread.sleep(1000);
            System.out.println(i);
        }
        System.out.println("抽中学员的姓名为"+sname[r]);
    }
}
