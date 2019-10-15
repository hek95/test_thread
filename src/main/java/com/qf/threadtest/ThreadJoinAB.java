package com.qf.threadtest;
//子线程A合并到子线程B
public class ThreadJoinAB extends  Thread  {
    //声名线程属性
    public Thread t1;

    @Override
    public void run() {
        for(int i=1;i<200;i++){
            System.out.println(this.getName()+":"+i);
            //当线程运行到10的时候就让线程A合并过来
            if(i==10&&this.getName().equals("子线程B")){
               //让线程A合并过来
                try{
                    this.t1.join();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }

        }
    }

    public static void main(String[] args) {
        //创建线程对象
        ThreadJoinAB td1=new ThreadJoinAB();
        ThreadJoinAB td2=new ThreadJoinAB();
        //设置线程的名称
        td1.setName("子线程A");
        td2.setName("子线程B");
        //将A线程当作B线程的属性传过去
        td2.t1=td1;
        //开启线程
        td1.start();
        td2.start();
    }
}
