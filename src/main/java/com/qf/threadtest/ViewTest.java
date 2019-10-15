package com.qf.threadtest;

import java.util.Scanner;

/**
 * 打印如下图形
 *  * * * * *
 *   * * * *
 *    * * *
 *     * *
 *      *
 *     * *
 *    * * *
 *   * * * *
 *  * * * * *
 */

//题目分析 要控制打印的的* 数 和打印的空格数
    //第一行打印五个* 0个空格  第二行打印一个空格 再打印四个*
public class ViewTest {
    public static void main(String[] args) {
        String str="* ";//要打印的* ;
        System.out.println("请输入打赢的星星数");
        Scanner input =new Scanner(System.in);
        int number=input.nextInt();
        int n=number; //设置n的初始值
        int m=0;//设置打印空格的初始值
        boolean flag=true; //设置打印星星是递增还是递减 true为递减
        for(;n<=number;){
            //打印每一行的空格
            for(int i=0;i<m;i++){
                 System.out.print(" ");
            }
            //打印星星
            for(int i=0;i<n;i++){
                System.out.print(str);
            }
            //转向 当n==1就设置flag为false
            if(n==1){
                flag=false;
            }
            if(flag){//星星递减时
                m++;
                n--;
            }else{//星星递增时
                m--;
                n++;
            }
           System.out.println(" "); //打印一行就换行
        }
    }


}
