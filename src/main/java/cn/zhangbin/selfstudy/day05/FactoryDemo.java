package cn.zhangbin.selfstudy.day05;

public class FactoryDemo {
    public static void main(String[] args) {
        IMessage msg = Factory.getMessageInstance("cn.zhangbin.selfstudy.day05.MessageImpl",MessageImpl.class);
        msg.send();
    }
}
interface IMessage{ // 消息接口
    public void send(); // 返送消息抽象类
}
class MessageImpl implements IMessage{ // 消息实现
    @Override
    public void send() {
        System.out.println("发送了一条消息!");
    }
}
class Factory{
    private Factory(){

    }
    public static<T> T getMessageInstance(String className,Class<T> classz){
        T instance = null;
        try {
            instance = (T) Class.forName(className).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return instance;
    }
}