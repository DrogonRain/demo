package cn.zhangbin.selfstudy.day06;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Demo3 {
    public static void main(String[] args) {
        IMessage msg = (IMessage) new MLDNProxy().bind(new MessageReal());
        msg.send();
    }
}
interface IMessage{ // 传统代理设计必须有接口
    public void send(); // 业务方法
}
class MessageReal implements IMessage{
    @Override
    public void send() {
        System.out.println("www.baidu.com");
    }
}
class MLDNProxy implements InvocationHandler{
    private Object target; // 保存真实业务对象

    /**
     * 进行真实业务对象与代理业务对象之间的绑定处理
     * @param target 真实业务对象
     * @return 由Proxy生成的代理业务对象
     */
    public Object bind(Object target){
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    public boolean connect(){
        System.out.println("消息代理 -- 进行消息发送通道的连接");
        return true;
    }

    public void close(){
        System.out.println("消息代理 -- 关闭消息通道");
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(" ------- 执行方法: "+method);
        Object returnObject = null;
        if (this.connect()){
            returnObject = method.invoke(this.target,args);
            this.close();
        }
        return returnObject;
    }
}
//
//public interface InvocationHandler{
//
//    /**
//     * 代理方法调用,代理主题类执行的方法最终都是此方法
//     * @param proxy 要代理的对象
//     * @param method 要执行的接口方法名称
//     * @param args 传递参数
//     * @return 某一个方法的返回值
//     * @throws Throwable 方法调用时出现的错误继续向上抛出
//     */
//    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
//}


//class MessageProxy implements IMessage{ // 代理类
//    private IMessage message; // 代理对象
//    public MessageProxy(IMessage message){
//        this.message = message;
//    }
//    @Override
//    public void send() {
//        if (this.connect()){
//            this.message.send(); // 消息的发送处理
//            this.close();
//        }
//    }
//    public boolean connect(){
//        System.out.println("消息代理 - 进行消息发送通道的链接");
//        return true;
//    }
//
//    public void close(){
//        System.out.println("关闭通道");
//    }
//}
