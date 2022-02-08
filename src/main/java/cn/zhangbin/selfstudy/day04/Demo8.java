package cn.zhangbin.selfstudy.day04;

import java.io.*;

public class Demo8 {
    public static void main(String[] args) throws Exception {
        File file = new File(File.separator+"Users"+File.separator+"zhangbin"+File.separator+"Desktop"+File.separator+"Study"+File.separator+"StudyTest"+File.separator+"test1.txt");
        PrintWriter pu = new PrintWriter(new FileOutputStream(file));
//        pu.println("姓名: 小强子");
//        pu.print("年龄: ");
//        pu.println(20);
        //格式化字符
        String name = "小强子";
        int age = 20;
        double salary = 12823.24231;
        pu.printf("姓名: %s \n年龄: %d \n月收入: %9.3f",name,age,salary);
        pu.close();
    }
}
//class PrintUtil { // 实现一些常用数据的输出
//    public OutputStream output; // 不管你现在如何进行输出操作,核心使用的就是OutPutStream
//    public PrintUtil(OutputStream output){ //由外部来决定输出的位置
//        this.output = output;
//    }
//    public void close() throws Exception{
//        this.output.close();
//    }
//    public void println(long num){
//        this.println(String.valueOf(num));
//    }
//    public void print(long num){
//        this.print(String.valueOf(num));
//    }
//    public void print(String str){ // 输出字符串
//        try {
//            this.output.write(str.getBytes()); // 输出
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    public void println(String str){
//        this.print(str + "\r\n");
//    }
//}
