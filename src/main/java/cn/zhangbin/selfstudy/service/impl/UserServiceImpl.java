package cn.zhangbin.selfstudy.service.impl;

import cn.zhangbin.selfstudy.service.IUserService;

public class UserServiceImpl implements IUserService {
    private int count = 0;
    @Override
    public boolean isExit() {
        return this.count >= 3;
    }

    @Override
    public boolean login(String name, String password) {
        this.count++;
        return "root".equals(name) && "123456".equals(password);
    }
}
