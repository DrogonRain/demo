package cn.zhangbin.selfstudy.test;

import cn.zhangbin.selfstudy.factory.Factory;

public class IOCLoginDemo {
    public static void main(String[] args) {
        System.out.println(Factory.loginInstance().login(null,null));
    }
}
