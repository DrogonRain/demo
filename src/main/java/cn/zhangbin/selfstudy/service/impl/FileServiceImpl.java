package cn.zhangbin.selfstudy.service.impl;

import cn.zhangbin.selfstudy.service.IFileService;
import cn.zhangbin.selfstudy.test.InputUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class FileServiceImpl implements IFileService {
    private String name;
    private String content;
    public FileServiceImpl(){
        this.name = InputUtil.getString("请输入保存文件名称: ");
        this.content = InputUtil.getString("请输入保存文件内容: ");
    }
    @Override
    public boolean save() {
        File file = new File(IFileService.SAVE_DIR + this.name);
        PrintWriter out = null;
        try {
            out = new PrintWriter(new FileOutputStream(file));
        } catch (FileNotFoundException e) {
            return false;
        }finally {
            if (out !=null){
                out.close();
            }
        }
        return true;
    }
}
