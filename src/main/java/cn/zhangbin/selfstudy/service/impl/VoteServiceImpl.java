package cn.zhangbin.selfstudy.service.impl;

import cn.zhangbin.selfstudy.service.IVoteService;
import cn.zhangbin.selfstudy.test.VoteStudent;

import java.util.Arrays;

public class VoteServiceImpl implements IVoteService {
    private VoteStudent[] students = new VoteStudent[]{
            new VoteStudent(2000801,"张三",0),
            new VoteStudent(2000802,"李四",0),
            new VoteStudent(2000803,"王五",0),
            new VoteStudent(2000804,"赵六",0)
    };
    @Override
    public boolean inc(int sid) {
        for (int i = 0; i < students.length; i++) {
            if (this.students[i].getSid() == sid) { // 获取了指定的编号
                this.students[i].setVote(this.students[i].getVote()+1);
                return true;
            }
        }
        return false;
    }

    @Override
    public VoteStudent[] result() {
        Arrays.sort(this.students);
        return this.students;
    }

    @Override
    public VoteStudent[] getData() {
        return this.students;
    }
}
