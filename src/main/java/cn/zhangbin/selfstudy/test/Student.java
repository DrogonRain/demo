package cn.zhangbin.selfstudy.test;

public class Student implements Comparable<Student>{
    private String name;
    private double score;
    public Student(String name,double score){
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "学生信息 - " + "姓名:" + name +", 成绩:" + score;
    }

    @Override
    public int compareTo(Student o) {
        if (o.score < this.score){
            return -1;
        }else if (o.score > this.score){
            return 1;
        }else {
            return 0;
        }
    }
}
