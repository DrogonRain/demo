package cn.zhangbin.selfstudy.day03;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Demo4 { // 添加26个小写字母,反转后去掉前五个字母
    public static void main(String[] args) {
        StringBuffer str = new StringBuffer();
        char ch = 97;
        for (int i = 0; i < 26; i++) {
            ch = 97;
            ch+=i;
            str.append(ch);
        }
        System.out.println(str.reverse().delete(0,5).length());
//        System.out.println(str.reverse().substring(5).length());
//        System.out.println(str.reverse().substring(5).toString());
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        System.out.println(new Demo4().getMessage(s));
    }
    private static final int CHINA = 1;
    private static final int USA = 2;
    private static final String KEY = "info";
    private static final String BASENAME = "Messages";

    public String getMessage(int num){
        Locale loc = this.getLocale(num);
        if (loc == null){
            return "Nothing";
        }else {
            return ResourceBundle.getBundle(BASENAME,loc).getString(KEY);
        }
    }

    private Locale getLocale(int num){
        switch (num){
            case CHINA:
                return new Locale("zh","CN");
            case USA:
                return new Locale("en","US");
            default:
                return null;
        }
    }
}
