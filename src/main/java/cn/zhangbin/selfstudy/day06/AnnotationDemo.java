package cn.zhangbin.selfstudy.day06;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

public class AnnotationDemo {
    public static void main(String[] args) throws Exception{
        Method method = Message.class.getMethod("send",String.class); // 获取指定方法
        DefaultAnnotation anno = method.getAnnotation(DefaultAnnotation.class); // 获取指定的Annotation
        String msg = anno.title() + "("+anno.url()+")"; // 消息内容
        method.invoke(Message.class.getDeclaredConstructor().newInstance(),msg); // 调用发送方法
    }
}

@Retention(RetentionPolicy.RUNTIME) // 定义Annotaiton的运行策略
@interface DefaultAnnotation{ // 自定义的Annotation
    public String title(); // 获取数据
    public String url() default "www.baidu.com"; // 获取数据,默认值
}
class Message{
    @DefaultAnnotation(title = "测试标题")
    public void send(String msg){
        System.out.println("[消息发送] - "+msg);
    }
}
