package cn.zhangbin.selfstudy.test;

import cn.zhangbin.selfstudy.service.INumberService;
import cn.zhangbin.selfstudy.service.impl.NumberServiceImpl;

public class IOCaseDemo {
    public static void main(String[] args) {
        INumberService numberService = new NumberServiceImpl();
        int[] result = numberService.stat(5);
        System.out.println("最大值为: "+result[0]+"\n最小值为: "+result[1]);
    }
}
