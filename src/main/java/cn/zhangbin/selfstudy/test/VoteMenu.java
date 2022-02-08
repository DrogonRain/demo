package cn.zhangbin.selfstudy.test;

import cn.zhangbin.selfstudy.factory.Factory;
import cn.zhangbin.selfstudy.service.IStudentService;
import cn.zhangbin.selfstudy.service.IVoteService;

import java.util.Arrays;

public class VoteMenu {
    private IVoteService voteService;
    public VoteMenu(){
        this.voteService = Factory.voteInstance();
        this.vote();
    }
    public void vote(){ // 投票处理
        VoteStudent[] stu = this.voteService.getData();
        for (VoteStudent temp : stu) {
            System.out.println(temp.getSid()+" - "+temp.getName()+" - 获得了"+temp.getVote()+"票");
        }
        int num = 10;
        while(num != 0){ // 循环投票
            num = InputUtil.getInt("请输入班长候选人代号(数字0结束)");
            if (num != 0){
                if (!this.voteService.inc(num)){
                    System.out.println("此选票无效,请输入正确的后选人代号! ");
                }
            }
        }
        System.out.println("投票最终结果: ");
        stu = this.voteService.result();
        System.out.println("恭喜"+stu[0].getName()+"同学,以"+stu[0].getVote()+"票当选班长!");
    }
}
