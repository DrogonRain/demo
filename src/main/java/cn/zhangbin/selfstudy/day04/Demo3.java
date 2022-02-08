package cn.zhangbin.selfstudy.day04;

import java.io.*;

public class Demo3 {
    public static void main(String[] args) throws Exception{
        // 字节流不会使用缓冲区而字符流涉及缓冲区,一般字符流更适用于处理中文
        File file = new File(File.separator+"Users"+File.separator+"zhangbin"+File.separator+"Desktop"+File.separator+"Study"+File.separator+"StudyTest"+File.separator+"test1.txt");
        if (!file.getParentFile().exists()){ // 若文件目录不存在
            file.getParentFile().mkdirs(); // 创建文件目录
        }
//        OutputStream out = new FileOutputStream(file); // 创建字节流
//        String str = "www.baidu.com"; // 指定一个字符串
//        out.write(str.getBytes()); // 将字符串转换为字节并写入文件内
//        out.close(); // 关闭流
//        try{ // 自动关闭流
//            OutputStream out = new FileOutputStream(file,true); // 创建文件,true代表追加,false代表覆盖
//            String str = "www.baidu.com\r\n"; // 指定一个字符串,\r\n标准换行
//            out.write(str.getBytes()); // 将字符串转换为字节并写入文件内
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//        Writer out = new FileWriter(file,true);
//        String str = "www.baidu.com\r\n";
//        out.write(str);
//        out.close();
        OutputStream out = new FileOutputStream(file); // 创建字节流
        Writer output = new OutputStreamWriter(out); // 字节流转为字符流
        output.write("张斌"); // 输入文字
        output.close(); // 关闭链接
    }
}
class JavaApiDemo{
    public static void main(String[] args) throws IOException {
        File file = new File(File.separator+"Users"+File.separator+"zhangbin"+File.separator+"Desktop"+File.separator+"Study"+File.separator+"StudyTest"+File.separator+"test1.txt");
        InputStream input = new FileInputStream(file);// 指定文件路径
        byte[] data = new byte[1024]; // 设定读取字节的大小
        int len = input.read(data); // 按照读取大小读取文件
        System.out.println(new String(data,0,len)); // 根据长度创建字符串保存值
        input.close(); // 关闭输入流
    }
}
