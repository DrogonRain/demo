package cn.zhangbin.selfstudy.day02;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class Demo2 {
    public static void main(String[] args) {
//        Locale aDefault = Locale.getDefault(); //获取默认开发环境
//        System.out.println(aDefault);
//        Locale china = Locale.CHINA; // 设置开发语言环境为中国
        Locale us = Locale.US;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = format.format(new Date());
        ResourceBundle resource = ResourceBundle.getBundle("Messages",us);// 获取指定位置资源文件
        String val = resource.getString("info");
        System.out.println(MessageFormat.format(val,"zhangbin",s));
    }
}
