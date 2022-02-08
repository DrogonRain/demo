package cn.zhangbin.selfstudy.test;

import cn.zhangbin.selfstudy.factory.Factory;
import cn.zhangbin.selfstudy.service.IFileService;

import java.io.File;

import static cn.zhangbin.selfstudy.service.IFileService.SAVE_DIR;

public class IOCFileCaseDemo {
    static{ // 项目启动时首先创建路径
        File file = new File(SAVE_DIR);
        if (!file.exists()){ // 如果文件目录不存在
            file.mkdirs(); // 创建目录
        }
    }
    public static void main(String[] args) {
        IFileService fileService = Factory.getFileInstance();
        System.out.println(fileService.save());
    }
}
