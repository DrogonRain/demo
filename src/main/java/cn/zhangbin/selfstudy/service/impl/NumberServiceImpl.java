package cn.zhangbin.selfstudy.service.impl;

import cn.zhangbin.selfstudy.service.INumberService;
import cn.zhangbin.selfstudy.test.InputUtil;

public class NumberServiceImpl implements INumberService {
    @Override
    public int[] stat(int count) {
        int[] result = new int[2]; // 定义返回结果
        int[] data = new int[count]; // 开辟一个数组
        for (int i = 0; i < data.length; i++) { // 循环输入数字
            data[i] = InputUtil.getInt("清输入第"+(i+1)+"个数字");
        }
        result[0] = data[0];
        result[1] = data[0]; // 将最大值和最小值都赋值为第一个元素
        for (int i = 1; i < data.length; i++) {
            if (data[i] > result[0]){
                result[0] = data[i];
            }
            if (data[i] < result[1]){
                result[1] = data[i];
            }
        }
        return result;
    }

    @Override
    public int[] ifStat() {
        int[] stat = new int[] {0,0}; // 第一个为奇数第二个为偶数
        String str = InputUtil.getString("请输入数字信息(以逗号分割)");
        String[] result = str.split(","); // 按照每个字符拆分
        for (int i = 0; i < result.length; i++) {
            if (Integer.parseInt(result[i]) % 2 != 0){
                stat[0] ++ ;
            }else{
                stat[1] ++ ;
            }
        }
        return stat;
    }
}
