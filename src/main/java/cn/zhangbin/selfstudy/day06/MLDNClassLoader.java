package cn.zhangbin.selfstudy.day06;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;

public class MLDNClassLoader extends ClassLoader{

    private static final String MESSAGE_CLASS_PATH = File.separator+"Users"+File.separator+"zhangbin"+File.separator+"Desktop"+File.separator+"Study"+File.separator+"Message.class";

    /**
     * 进行指定类的加载
     * @param className 类的完整名称"包,类"
     * @return 返回一个指定类的Class对象
     * @throws Exception 如果类文件不存在则无法加载
     */
    public Class<?> loadData(String className) throws Exception{
        byte[] data = this.loadClassData(); // 读取二进制数据文件
        if (data != null){ // 读到了
            return super.defineClass(className,data,0,data.length);
        }
        return null;
    }

    private byte[] loadClassData() throws Exception{
        InputStream input = null;
        ByteArrayOutputStream bos = null; // 将数据加载到内存中
        byte[] data = null;
        try{
            bos = new ByteArrayOutputStream();
            input = new FileInputStream(new File(MESSAGE_CLASS_PATH));
            data = new byte[1024];
            int len = 0;
            while ((len = input.read(data))!= -1){
                bos.write(data,0,len); // 所有的数据保存到内存流
            }
            data = bos.toByteArray();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            if (input != null){
                input.close();
            }
            if (bos != null){
                bos.close();
            }
        }
        return data;
    }
}
