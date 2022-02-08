package cn.zhangbin.selfstudy.day03;

import java.util.Arrays;

public class Demo6 {
    public static void main(String[] args) {
        String str = "张三:21:80|李四:22:80|王五:20:70";
        String[] result = str.split("\\|");
        String[] split = {};
        Student[] students = new Student[result.length];
        for (int i = 0; i < result.length; i++) {
            split = result[i].split(":");
            students[i] = new Student(split[0],Integer.parseInt(split[1]),Integer.parseInt(split[2]));
        }
        Arrays.sort(students);
        System.out.println(Arrays.toString(students));
    }
}
class Student implements Comparable<Student>{
    private String name;
    private int age;
    private int score;

    public Student(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public int compareTo(Student st) {
        if (st.getScore()!=this.score){
            return this.score-st.getScore();
        }else {
            return this.age-st.getAge();
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}
