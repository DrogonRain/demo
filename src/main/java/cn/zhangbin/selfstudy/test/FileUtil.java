package cn.zhangbin.selfstudy.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class FileUtil {
    public static String load(File file){
        Scanner scan = null;
        try {
            scan = new Scanner(file); // 文件加载
            if (scan.hasNext()){
                String str = scan.next(); // 获取数据
                return str;
            }
            return null;
        } catch (FileNotFoundException e) {
            return null;
        }finally {
            if (scan != null){
                scan.close();
            }
        }
    }
    public static boolean append(File file,String content){
        PrintStream out = null;
        try {
            out = new PrintStream(new FileOutputStream(file,true));
            out.print(content); // 内容追加
            return true;
        } catch (FileNotFoundException e) {
            return false;
        }finally {
            if (out != null){
                out.close();
            }
        }
    }
}
