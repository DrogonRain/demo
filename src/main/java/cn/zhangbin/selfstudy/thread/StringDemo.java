package cn.zhangbin.selfstudy.thread;

public class StringDemo {
    public static void main(String[] args) {
        String str = "hello ";
        change(str);
        System.out.println(str);
        StringBuffer str2 = new StringBuffer();
        str2.append("hello ");
        change2(str2);
        System.out.println(str2.toString());
        System.out.println(str2.reverse());
        CharSequence chr = "www.baidu.com";
        System.out.println(chr.charAt(4));
    }
    public static void change(String str){
        str = str + "temp";
    }
    public static void change2(StringBuffer str){
        str.append("temp");
    }
}
