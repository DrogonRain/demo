package cn.zhangbin.selfstudy.day02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo1 {
    public static void main(String[] args) throws ParseException {
        //身份证验证
        String regix = "^[1-9]\\d{9}(0[1-9]|(1|[0-2]))([0-2][1-9]|10|20|30|31)\\d{3}[0-9Xx]";
        String str = "150421200007210012";
        System.out.println(str.matches(regix));
        //替换非字母数字
        String str2 = "JSK@#!#ADJWIAO!@#!132142132";
        String regix2 = "[^a-zA-Z0-9]+";
        System.out.println(str2.replaceAll(regix2,""));
        //判断日期
        String regix3 = "^(\\d{4})-((0[1-9])|(1[0-2]))-([0-2][1-9]|10|20|30|31)";
        String date = "1998-07-21";
        if (date.matches(regix3))
            System.out.println(new SimpleDateFormat("yyyy-MM-dd").parse(date));
        //验证email格式,email由字符数字下划线,域名由字母数字下划线和-所组成,域名必须为.cn/.com/.net/.com.cn/.gov
        String regix4 = "[a-zA-Z0-9]*\\w+@\\w+(\\.(cn|com|net|(com\\.cn)|gov))";
        String email = "zb721720@163.gov";
        System.out.println(email.matches(regix4));
        String sql = "INSERT INTO dept(deptno,dname,loc) VALUES(#{deptno},#{dname},#{loc})";
        String regex = "#\\{\\w+\\}";
        Pattern pattern = Pattern.compile(regex); //编译正则表达式
        Matcher matcher = pattern.matcher(sql);
        System.out.println(matcher.matches());//验证匹配结果
        while(matcher.find()){ //验证是否有匹配内容
            System.out.println(matcher.group(0).replaceAll("#|\\{|\\}",""));//分组后替换其他字符
        }
    }
}
