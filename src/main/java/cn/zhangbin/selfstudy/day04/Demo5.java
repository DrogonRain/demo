package cn.zhangbin.selfstudy.day04;

import java.io.*;

public class Demo5 {

    public static void main(String[] args) throws IOException {
//        OutputStream file = new FileOutputStream(File.separator+"Users"+File.separator+"zhangbin"+File.separator+"Desktop"+File.separator+"Study"+File.separator+"StudyTest"+File.separator+"test1.txt");
//        file.write("中华人民共和国万岁".getBytes("ISO8859-1"));
//        file.close();
        String str = "www.baidu.com"; // 小写字母字符串
        InputStream input = new ByteArrayInputStream(str.getBytes()); // 将数据保存在内存流
        ByteArrayOutputStream out = new ByteArrayOutputStream(); // 读取内存中的数据
        int data = 0;
        while((data = input.read()) != -1){ // 每次读取一个字节
            out.write(Character.toUpperCase(data)); // 保存数据
        }
        byte[] result = out.toByteArray(); // 以字节的形式读取数据
        System.out.println(new String(result)); // 转为字符串输出
        input.close();
        out.close();
    }
}
