package cn.zhangbin.selfstudy.day04;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

class MathUtil{
    private MathUtil(){}
    public static double round(double num,int scale){
        return Math.round(Math.pow(10,scale) * num) / Math.pow(10,scale);
    }
}
public class Demo1 {
    //创建文件
    public static void main(String[] args) throws IOException {
//        File file = new File(File.separator+"Users"+File.separator+"zhangbin"+File.separator+"Desktop"+File.separator+"Study"+File.separator+"test.txt");
//        if (file.getParentFile().exists()){// 判断父级目录是否存在
//            System.out.println("文件父级存在!");
//        }
//        if (file.exists()){ // 判断文件是否已经存在
//            file.delete(); // 若存在,则删除文件
//        }else {
//            System.out.println(file.createNewFile()); // 若不存在,则创建文件
//        }
        File file = new File(File.separator+"Users"+File.separator+"zhangbin"+File.separator+"Desktop"+File.separator+"Study"+File.separator+"91643117975_.pic.jpg");
        System.out.println("文件是否可读: "+file.canRead()+" -- 文件是否可写: "+file.canWrite());
        System.out.println("文件大小: "+MathUtil.round(file.length()/(double)1024/1024,3));
        System.out.println("最后修改时间: "+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(file.lastModified()));
        System.out.println("该路径所获取的是目录吗? "+file.isDirectory());
        System.out.println("该路径所获取的是文件吗? "+file.isFile());
        file = new File(File.separator+"Users"+File.separator+"zhangbin"+File.separator+"Desktop"+File.separator+"Study");
        if (file.isDirectory()){ // 如果是目录则获取目录中所有文件
            File[] result = file.listFiles();
            for (int i = 0; i < result.length; i++) {
                System.out.println(result[i].getName());
            }
        }

    }
}
