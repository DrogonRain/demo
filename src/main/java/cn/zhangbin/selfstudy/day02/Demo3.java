package cn.zhangbin.selfstudy.day02;

import java.awt.image.ImageConsumer;
import java.util.Optional;
import java.util.UUID;

public class Demo3 {
    public static void main(String[] args) {
//        UUID uid = UUID.randomUUID();
//        System.out.println(uid.toString());
        IMessage message = MessageUtil.getMessage().orElse(null); // 若为空则创建
        MessageUtil.useMessage(message);
    }
}
class MessageUtil{
    private MessageUtil() {}
    public static Optional<IMessage> getMessage(){
        return Optional.ofNullable(new MessageImpl()); // 有对象
    }
    public static void useMessage(IMessage message){
        System.out.println(message.getContent());
    }
}
interface IMessage{
    public String getContent();
}
class MessageImpl implements IMessage{

    @Override
    public String getContent() {
        return "www.baidu.com";
    }
}
