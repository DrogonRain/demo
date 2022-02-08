package cn.zhangbin.selfstudy.factory;

import cn.zhangbin.selfstudy.service.*;
import cn.zhangbin.selfstudy.service.impl.*;
import cn.zhangbin.selfstudy.test.InputUtil;

public class Factory {
    private Factory(){}
    public static INumberService getInstance(){
        return new NumberServiceImpl();
    }
    public static IFileService getFileInstance(){
        return new FileServiceImpl();
    }
    public static IStringService getString(){
        return new StringServiceImpl();
    }
    public static IStudentService getStudent(){
        return new StudentServiceImpl();
    }
    public static IUserService loginInstance(){
        return new UserServiceProxy(new UserServiceImpl());
    }
    public static IVoteService voteInstance(){
        return new VoteServiceImpl();
    }
}
