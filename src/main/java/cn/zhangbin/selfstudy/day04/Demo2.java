package cn.zhangbin.selfstudy.day04;

import java.io.File;
import java.io.IOException;

public class Demo2 {
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis(); // 获取起始时间
        File file = new File(File.separator+"Users"+File.separator+"zhangbin"+File.separator+"Desktop"+File.separator+"Study"+File.separator+"upload");
        renameFile(file);
        long end = System.currentTimeMillis(); //获取结束时间
        System.out.println("运行时间为: "+(end - start)); // 计算运行时间
    }
    private static void renameFile(File file){
        if (file.isDirectory()){
            File[] result = file.listFiles();
            for (int i = 0; i < result.length; i++) {
                if (file.getName()!=".DS_Store")
                    renameFile(result[i]); // 获取目录所有文件后递归调用重命名方法
            }
        }else if (file.isFile()){
            String fileName = null; // 用于存储文件名称
            if (file.getName().contains(".")){ // 如果文件名称当中包含"."
                fileName = file.getName().substring(0,file.getName().lastIndexOf(".")) + ".png"; // 根据最后一个"."的下标进行截取
            }else{
                fileName = file.getName()+".png";
            }
            File newFile = new File(file.getParent(),fileName);
            file.renameTo(newFile); // 重命名
        }
    }
}
