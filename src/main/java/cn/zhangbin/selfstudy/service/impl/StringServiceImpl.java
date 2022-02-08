package cn.zhangbin.selfstudy.service.impl;

import cn.zhangbin.selfstudy.service.IStringService;

public class StringServiceImpl implements IStringService {
    private StringBuffer data = new StringBuffer();
    @Override
    public void append(String str) {
        this.data.append(str).append("|");
    }
    @Override
    public String[] reverse() {
        String[] result = this.data.toString().split("\\|");
        int center = result.length / 2;
        int head = 0;
        int tail = result.length - 1;
        for (int i = 0; i < center; i++) {
            String temp = result[head];
            result[head] = result[tail];
            result[tail] = temp;
        }
        return result;
    }
}
