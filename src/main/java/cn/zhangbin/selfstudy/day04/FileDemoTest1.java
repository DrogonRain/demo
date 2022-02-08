package cn.zhangbin.selfstudy.day04;

import java.io.*;

public class FileDemoTest1 {
    // 第一种形式,do_while进行拷贝
    //File.separator+"Users"+File.separator+"zhangbin"+File.separator+"Desktop"+File.separator+"Study"+File.separator+"5ed0bacb-1e16-4fe8-984a-0ce322e69293.png"
    public static void main(String[] args) throws Exception {
        String[] arrs = new String[2];
        arrs[0] = File.separator+"Users"+File.separator+"zhangbin"+File.separator+"Desktop"+File.separator+"Study"+File.separator+"upload";
        arrs[1] = File.separator+"Users"+File.separator+"zhangbin"+File.separator+"Desktop"+File.separator+"Study"+File.separator+"hello";
        if (arrs.length != 2){ // 程序运行出错
            System.out.println("命令执行错误, 执行结构: java FileDemoTest1 源文件路径 目标文件路径");
        }
        long start = System.currentTimeMillis();
        FileUtil fu = new FileUtil(arrs[0],arrs[1]);
        if (new File(arrs[0]).isFile()){
            System.out.println(fu.copy() ? "文件拷贝成功!" : "文件拷贝失败!");
        }else {
            System.out.println(fu.copyDir()  ? "目录拷贝成功!" : "目录拷贝失败!");
        }

        long end = System.currentTimeMillis();
        System.out.println("拷贝共计消耗时间: "+(end - start));
    }
}
class FileUtil{ // 定义一个文件操作的工具类
    private File srcFile; // 源文件路径
    private File desFile; // 目标文件路径
    public FileUtil(String src, String des){
        this(new File(src),new File(des));
    }
    public FileUtil(File srcFile,File desFile){
        this.srcFile = srcFile;
        this.desFile = desFile;
    }
    public boolean copyDir() throws Exception {
        this.copyImpl(this.srcFile);
        try{
            return true;
        }catch (Exception e){
            return false;
        }
    }
    private void copyImpl(File file) throws Exception {
        if (file.isDirectory()){ // 如果是目录则
            File[] result = file.listFiles(); // 列出全部文件
            if (result != null){
                for (int i = 0; i < result.length; i++) {
                    copyImpl(result[i]);
                }
            }
        }else {
            String newFilePath = file.getPath().replace(this.srcFile.getPath()+File.separator,"");
            File newFile = new File(this.desFile,newFilePath); //  目标文件路径
            this.copyFileImpl(file,newFile);
        }
    }

    private boolean copyFileImpl(File srcFile,File desFile) throws Exception{
        if (!desFile.getParentFile().exists()) { // 目标文件目录不存在
            desFile.getParentFile().mkdirs(); // 创建父目录
        }
        byte[] data = new byte[1024];  // 开辟一个拷贝的缓冲区
        InputStream input = null;
        OutputStream out = null;
        try {
            input = new FileInputStream(srcFile);
            out = new FileOutputStream(desFile);
            int len = 0;
            while ((len = input.read(data))!=-1){
                out.write(data,0,len);
            }
            return true;
        } catch (Exception e) {
            throw e;
        } finally {
            if (input != null) {
                input.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
    public boolean copy() throws Exception {// 文件拷贝
        if (!this.srcFile.exists()) { // 源文件不存在
            System.out.println("拷贝的源文件不存在!");
            return false; // 拷贝失败
        }

        return this.copyFileImpl(this.srcFile,this.desFile);
    }
}