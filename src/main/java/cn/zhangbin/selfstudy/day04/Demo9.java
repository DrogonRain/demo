package cn.zhangbin.selfstudy.day04;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Demo9 {
    public static void main(String[] args) throws IOException, ParseException {
//        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
//        System.out.print("请输入您的年龄: ");
//        String msg = input.readLine();  // 接受输入信息
//        if (msg.matches("\\d{1,3}")){ // 验证是否由数字组成
//            int age = Integer.parseInt(msg); // 转为数字并存储为年龄
//            System.out.println("输入的年龄为: "+age);
//        }else{
//            System.out.println("请您确保看懂我的提示,不要随意输入");
//        }
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您的生日: (注:格式为XXXX-XX-XX)");
        if (sc.hasNext("\\d{4}-\\d{2}-\\d{2}")){
            String str = sc.next("\\d{4}-\\d{2}-\\d{2}");
            System.out.println("您的生日为: "+ new SimpleDateFormat("yyyy-MM-dd").parse(str));
        }else{
            System.out.println("您输入的日期格式不正确!");
        }
        sc.close();
        Scanner s2 = new Scanner(new File(File.separator+"Users"+File.separator+"zhangbin"+File.separator+"Desktop"+File.separator+"Study"+File.separator+"StudyTest"+File.separator+"test1.txt"));
        s2.useDelimiter("\n"); // 设置读取分隔符
        while (s2.hasNext()){
            System.out.println(s2.next());
        }
        s2.close();
    }
}
