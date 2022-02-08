package cn.zhangbin.selfstudy.service.impl;

import cn.zhangbin.selfstudy.service.IUserService;
import cn.zhangbin.selfstudy.test.InputUtil;

public class UserServiceProxy implements IUserService {
    private IUserService userService;
    public UserServiceProxy(IUserService userService){
        this.userService = userService;
    }
    @Override
    public boolean isExit() {
        return userService.isExit();
    }

    @Override
    public boolean login(String name, String password) {
        while (!this.isExit()){ // 不进行退出
            String inputData = InputUtil.getString("请输入登录信息: ");
            if (inputData.contains("/")){ // 输入了用户名和密码
                String temp[] = inputData.split("/"); // 数据拆分
                if (this.userService.login(temp[0],temp[1])){ // 进行登录认证
                    return true; // 循环结束了
                }else{
                    System.out.println("登录失败,错误的用户名和密码! ");
                }
            }else{ // 仅输入了用户名
                String pwd = InputUtil.getString("请输入密码: ");
                if (this.userService.login(inputData,pwd)){ // 进行登录验证
                    return true;
                }else{
                    System.out.println("登录失败,错误的用户名或密码!");
                }
            }
        }
        return false;
    }
}
