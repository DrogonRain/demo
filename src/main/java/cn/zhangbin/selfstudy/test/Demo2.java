package cn.zhangbin.selfstudy.test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Demo2 {
    /**
     * 查找两个数的最大公约数
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number1 = sc.nextInt();
        int number2 = sc.nextInt();
        int max = Math.max(number1,number2);
        int min = Math.min(number1,number2);
        Queue<Integer> queue = new LinkedList<>();
        for (int i = min; i > 0; i--) {
            if (max%i == min%i && max%i==0 && min%i==0){
                queue.offer(i);
            }
        }
        System.out.println("最大公约数为: "+queue.poll()); 
    }
}
