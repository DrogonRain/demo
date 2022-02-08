package cn.zhangbin.selfstudy.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class InputUtil {
    private static final BufferedReader INPUT = new BufferedReader(new InputStreamReader(System.in));
    private InputUtil() {}
    public static String getString(String prompt){
        String str = null;
        boolean flag = true;
        while (flag){
            System.out.println(prompt);
            try {
                str = INPUT.readLine();
                if (!"".equals(str)){ // 不是空字符串
                    flag = false; // 结束循环
                } else  {
                    System.out.println("输入的内容不允许为空!");
                }
            } catch (IOException e) {
                System.out.println("输入的内容不允许为空!");
            }
        }
        return str;
    }
    /**
     * 实现键盘接受数字的操作
     * @param prompt 提示信息
     * @return 一个可以使用的数字
     */
    public static int getInt(String prompt){
        int num = 0;
        while (true){
            System.out.println(prompt); // 打印提示信息
            Scanner input = new Scanner(System.in);
            if (input.hasNext("\\d+")){
                num = input.nextInt();
                break;
            }else{
                System.out.println("输入的内容不是数字,请重新输入!");
            }
        }
        return num;
    }
}
