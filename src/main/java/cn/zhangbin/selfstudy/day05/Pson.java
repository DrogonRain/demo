package cn.zhangbin.selfstudy.day05;

import cn.zhangbin.selfstudy.service.IChannelService;
import cn.zhangbin.selfstudy.service.IMessageService;

public class Pson extends AbstractBase implements IMessageService, IChannelService {// 任何情况下如果实例化类对象则一定要调用类中的构造方法

    private String name;
    private int age;

    public Pson(){}
    public Pson(String name,int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pson{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean connect() {
        return true;
    }

    @Override
    public void send() {
        if (this.connect()){
            System.out.println("[消息发送]www.baidu.com");
        }
    }

}
