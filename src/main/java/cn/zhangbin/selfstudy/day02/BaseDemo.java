package cn.zhangbin.selfstudy.day02;

import com.sun.org.apache.regexp.internal.RE;

import java.util.Base64;

public class BaseDemo {
    public static void main(String[] args) {
        String str = "www.baidu.com";
//        //普通数据加密
//        String encodeMsg = new String(Base64.getEncoder().encode(str.getBytes()));
//        System.out.println(encodeMsg);
//        //普通数据解密
//        String decodeMsg = new String(Base64.getDecoder().decode(encodeMsg));
//        System.out.println(decodeMsg);
        String encode = StringUtil.encode(str);
        System.out.println(encode);
        String decode = StringUtil.decode(encode);
        System.out.println(decode);
    }
}
class StringUtil{
    private static final String SALT = "byte"; // 公共盐值
    private static final int REPEAT = 5; // 加密次数

    /**
     * 进行加密
     * @param str 需要加密的数据
     * @return 加密后的数据
     */
    public static String encode(String str){ // 进行加密
        String temp = str + "{"+SALT+"}";
        byte[] bytes = temp.getBytes();
        for (int i = 0; i < REPEAT; i++) {
            bytes = Base64.getEncoder().encode(bytes);
        }
        return new String(bytes);
    }

    /**
     * 进行解密
     * @param password 加密的数据
     * @return 解密后的数据
     */
    public static String decode(String password){
        byte[] bytes = password.getBytes();
        for (int i = 0; i < REPEAT; i++) {// 根据次数进行解密
            bytes = Base64.getDecoder().decode(bytes);
        }
        //将解密后的数据进行处理
        return new String(bytes).replaceAll("\\{\\w+\\}","");
    }
}
