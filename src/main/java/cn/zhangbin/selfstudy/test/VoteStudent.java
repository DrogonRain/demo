package cn.zhangbin.selfstudy.test;

public class VoteStudent implements Comparable<VoteStudent>{

    private long sid; // 学号
    private String name; // 学生姓名
    private int vote; // 票数

    public long getSid() {
        return sid;
    }

    public void setSid(long sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }

    public VoteStudent(long sid, String name, int vote) {
        this.sid = sid;
        this.name = name;
        this.vote = vote;
    }

    @Override
    public String toString() {
        return "["+this.sid+"]"+this.name+"同学的票数为: "+this.vote;
    }

    @Override
    public int compareTo(VoteStudent stu) {
        return stu.vote - this.vote; // 降序排列
    }
}
