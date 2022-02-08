package cn.zhangbin.selfstudy.service;

import cn.zhangbin.selfstudy.test.Student;

public interface IStudentService {
    public void append(String str); // 追加数据并且保存到文件
    public Student[] getData(); // 获取排序数据
}
