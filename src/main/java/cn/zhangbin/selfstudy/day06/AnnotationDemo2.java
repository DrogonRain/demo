package cn.zhangbin.selfstudy.day06;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class AnnotationDemo2 {
    public static void main(String[] args) {
        MessageService msg = new MessageService();
        msg.send("www.baidu.com");
    }
}
@Retention(RetentionPolicy.RUNTIME)
@interface UseMessage{
    public Class<?> clazz();
}
@UseMessage(clazz = NetMessageImpl.class)
class MessageService{
    private IMessage2 message;
    public MessageService(){
        UseMessage use = MessageService.class.getAnnotation(UseMessage.class);
        this.message = (IMessage2) Factory.getInstance(use.clazz()); // 直接通过Annotation进行获取
    }
    public void send(String msg){
        this.message.send(msg);
    }
}
class Factory{
    private Factory(){}
    public static <T> T getInstance(Class<T> clazz){// 返回一个实例化对象
        try{
            return (T) new MessageProxy().bind(clazz.getDeclaredConstructor().newInstance());
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
class MessageProxy implements InvocationHandler{

    private Object target;

    public Object bind(Object target){
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    public boolean connect(){
        System.out.println("代理操作 - 进行消息发送通道的链接");
        return true;
    }

    public void close(){
        System.out.println("代理操作 - 关闭发送通道");
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try{
            if (this.connect()){
                return method.invoke(this.target, args);
            } else {
                throw new Exception("ERROR - 消息无法进行发送");
            }
        }finally {
            this.close();
        }
    }
}
interface IMessage2{
    public void send(String msg);
}
class MessageImpl implements IMessage2{
    @Override
    public void send(String msg) {
        System.out.println("消息发送 - "+msg);
    }
}
class NetMessageImpl implements IMessage2{
    @Override
    public void send(String msg) {
        System.out.println("网络消息发送 - "+msg);
    }
}