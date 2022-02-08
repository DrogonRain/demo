package cn.zhangbin.selfstudy.test;

import cn.zhangbin.selfstudy.factory.Factory;
import cn.zhangbin.selfstudy.service.IStringService;
import cn.zhangbin.selfstudy.service.IStudentService;

import java.util.Arrays;

public class StudentMenu {
    public StudentMenu(){
        this.choose();
    }
    public void choose(){
        this.show();
        String choose = InputUtil.getString("请进行选择: ");
        switch (choose){
            case "1" : { // 接受输入数据
                String str = InputUtil.getString("请输入想要追加的数据: ");
                IStudentService studentService = Factory.getStudent();
                studentService.append(str); // 追加数据
                choose(); // 重复出现
            }
            case "2" : { // 接受输入数据
                IStudentService studentService = Factory.getStudent();
                System.out.println(Arrays.toString(studentService.getData()));
                choose();
            }
            case "0" : { // 接受输入数据
                System.out.println("下次再见,拜拜!");
                System.exit(1); // 退出
            }
            default : {
                System.out.println("您输入了非法字符串,无法进行处理,请重新输入!");
                choose();
            }
        }
    }
    public void show(){
        System.out.println("[1]追加字符串数据\n");
        System.out.println("[2]显示所有学生数据\n");
        System.out.println("[0]结束程序运行\n");
    }
}
