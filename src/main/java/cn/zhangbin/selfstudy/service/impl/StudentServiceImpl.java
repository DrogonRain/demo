package cn.zhangbin.selfstudy.service.impl;

import cn.zhangbin.selfstudy.service.IStudentService;
import cn.zhangbin.selfstudy.test.FileUtil;
import cn.zhangbin.selfstudy.test.Student;

import java.io.File;
import java.util.Arrays;

public class StudentServiceImpl implements IStudentService {
    private static final File SAVE_FILE = new File(File.separator+"Users"+File.separator+"zhangbin"+File.separator+"Desktop"+File.separator+"Study"+File.separator+"student.txt");
    private String content;
    private Student[] students;
    public StudentServiceImpl(){
        this.content = FileUtil.load(SAVE_FILE); // 读取已有的数据文件内容
        this.handle();
    }
    private void handle(){ // 进行字符串排序数据
        if (this.content == null || "".equals(this.content)){
            return; // 没有数据可以处理
        }
        String[] result = this.content.split("\\|"); // 拆分数据
        this.students = new Student[result.length];
        for (int i = 0; i < result.length; i++) {
            String[] temp = result[i].split(":");
            this.students[i] = new Student(temp[0],Double.parseDouble(temp[1]));
        }
    }

    @Override
    public void append(String str) {
        if (str.startsWith("|")){ // 如果最前面有"|"
            str = str.substring(1); // 则进行截取
        }
        if (!str.endsWith("|")){ // 数据合理,可以直接追加
            str = str + "|"; // 向后面追加|便于分割
        }
        FileUtil.append(SAVE_FILE,str); // 数据追加处理
    }

    @Override
    public Student[] getData() {
        Arrays.sort(this.students);
        return this.students;
    }
}
