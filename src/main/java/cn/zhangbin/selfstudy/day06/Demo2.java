package cn.zhangbin.selfstudy.day06;


import java.lang.reflect.Method;

public class Demo2 {
    public static void main(String[] args) throws Exception{
        MLDNClassLoader classLoader = new MLDNClassLoader(); // 实例化自定义类加载器
        Class<?> cls = classLoader.loadData("cn.zhangbin.selfstudy.day06.Message"); // 进行类的加载
        Object obj = cls.getDeclaredConstructor().newInstance(); // 实例化对象
        Method method = cls.getDeclaredMethod("send");
        method.invoke(obj);
    }
}
