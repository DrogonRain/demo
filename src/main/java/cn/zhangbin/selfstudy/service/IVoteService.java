package cn.zhangbin.selfstudy.service;

import cn.zhangbin.selfstudy.test.VoteStudent;

public interface IVoteService {
    public boolean inc(int sid); //  根据编号进行增长
    public VoteStudent[] result(); // 获取投票的结果
    public VoteStudent[] getData(); // 获取学生信息
}
