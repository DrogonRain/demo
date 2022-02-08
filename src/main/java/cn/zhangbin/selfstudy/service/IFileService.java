package cn.zhangbin.selfstudy.service;

import java.io.File;

public interface IFileService {
    public static final String SAVE_DIR = File.separator+"Users"+File.separator+"zhangbin"+File.separator+"Desktop"+File.separator+"Study"+File.separator+"StudyTest"+File.separator;
    /**
     * 定义文件的保存处理方法
     * @return 返回创建是否成功的检验值
     */
    public boolean save();
}
