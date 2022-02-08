package cn.zhangbin.selfstudy.day04;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Demo7 {
    public static void main(String[] args) throws IOException {
        File file = new File(File.separator+"Users"+File.separator+"zhangbin"+File.separator+"Desktop"+File.separator+"Study"+File.separator+"StudyTest"+File.separator+"test1.txt");
//        RandomAccessFile raf = new RandomAccessFile(file,"rw"); // 读写模式
//        String names[] = new String[] {"zhangsan","wangwu  ","lisi    "};
//        int ages[] = new int[] {30,20,16};
//        for (int i = 0; i < names.length; i++) {
//            raf.write(names[i].getBytes()); // 写入字符串
//            raf.writeInt(ages[i]);
//        }
//        raf.close();
        RandomAccessFile raf = new RandomAccessFile(file,"rw"); // 读写模式
        { // 读取"李四"的数据,跳过24位
            raf.skipBytes(24); // 向下跳
            byte[] data = new byte[8];
            int len = raf.read(data);
            System.out.println("姓名: "+new String(data,0,len).trim()+", 年龄: "+raf.readInt());
        }
        { // 读取"李四"的数据,跳过24位
            raf.seek(12); // 往回跳
            byte[] data = new byte[8];
            int len = raf.read(data);
            System.out.println("姓名: "+new String(data,0,len).trim()+", 年龄: "+raf.readInt());
        }
        { // 读取"李四"的数据,跳过24位
            raf.seek(0);
            byte[] data = new byte[8];
            int len = raf.read(data);
            System.out.println("姓名: "+new String(data,0,len).trim()+", 年龄: "+raf.readInt());
        }
        raf.close();
    }
}
