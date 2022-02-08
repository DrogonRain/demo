package cn.zhangbin.selfstudy.day05;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class JavaApiDemo {
    public static void main(String[] args) throws Exception {
        Class<?> cls = Class.forName("cn.zhangbin.selfstudy.day05.Pson"); // 获取指定Class对象
        String value = "小强子"; // 要设置的属性内容
        // 1.任何情况下如果要想保存类中的属性或者类中的方法都必须保证存在有实例化对象,既然不允许导入包,那么就反射实例化
        Object obj = cls.getDeclaredConstructor().newInstance(); // 调用无参构造方法
        // 2. 如果要想进行方法调用,那么一定要获取方法的名称
        String setMethodName = "setName"; // 方法名称
        Method setMethod = cls.getDeclaredMethod(setMethodName,String.class); // 获取指定的方法
        setMethod.invoke(obj,value); // 等价于  -  对象.setName(value)
        String getMethodName = "getName"; // 方法名称
        Method getMethod = cls.getDeclaredMethod(getMethodName); // 获取Getter方法
        System.out.println(getMethod.invoke(obj)); // 等价于   -  对象.getName()
        { // 获取父类中定义的公共成员变量
            Field[] fields = cls.getFields(); // 获取成员
            for (Field fie : fields) {
                System.out.println(fie);
            }
        }
        System.out.println("---------------");
        { // 获取子类中的成员
            Field[] fields = cls.getDeclaredFields(); // 获取成员
            for (Field fie : fields) {
                System.out.println(fie);
            }
        }

        Object obj2 = cls.getConstructor().newInstance(); // 实例化对象
        Field nameField = cls.getDeclaredField("name");
        System.out.println(nameField.getType().getName()); // 获取类的完整名称
        System.out.println(nameField.getType().getSimpleName()); // 获得类名本身
        nameField.setAccessible(true); // 解除封装
        nameField.set(obj2,"张三");
        System.out.println(nameField.get(obj2));


//        Class<?> cls = Pson.class; // 获取指定的类的Class对象
//        Package pack = cls.getPackage(); // 获取指定类的包
//        System.out.println(pack.getName());
//        Class<?> superclass = cls.getSuperclass();
//        System.out.println(superclass.getName()); // 获取指定类的父类
//        System.out.println(superclass.getSuperclass().getName()); // 获取指定类的超类
//        Class<?>[] interfaces = cls.getInterfaces();
//        for (Class<?> temp : interfaces) { // 获取指定类的所有实现接口
//            System.out.print(temp.getName()+"  ");
//        }
//        System.out.println();
//        Constructor<?>[] constructors = cls.getDeclaredConstructors();
//        for (Constructor<?> constructor : constructors) {
//            System.out.println(constructor);
//        }
//        Constructor<?> constructor = cls.getConstructor(String.class,int.class);
//        Object object = constructor.newInstance("张三", 20);
//        System.out.println(object);
//        { // 获取全部方法(包括父类中的方法)
//            Method[] methods = cls.getMethods();
//            for (Method met : methods) {
//                System.out.println(met);
//            }
//        }
//        System.out.println("-------------------------------------");
//        { // 获取本类方法
//            Method[] methods = cls.getDeclaredMethods();
//            for (Method met : methods) {
//                System.out.println(met);
//            }
//        }
//        Method[] methods = cls.getMethods();
//        for (Method met: methods) {
//            int mod = met.getModifiers(); // 修饰符
//            System.out.print(Modifier.toString(mod) + " ");
//            System.out.print(met.getReturnType().getName() + " ");
//            System.out.print(met.getName() + "(");
//            Class<?>[] params = met.getParameterTypes(); // 获取参数类型
//            for (int i = 0; i < params.length; i++) {
//                System.out.print(params[i].getName() + " " + "arg-" + i);
//                if (i < params.length -1 ){
//                    System.out.print(",");
//                }
//            }
//            System.out.print(")");
//            Class<?>[] exp = met.getExceptionTypes();
//            if (exp.length > 0){
//                System.out.print(" throws ");
//            }
//            for (int i = 0; i < exp.length; i++) {
//                System.out.print(exp[i].getName());
//                if (i < exp.length -1){
//                    System.out.print(",");
//                }
//            }
//            System.out.println();
//        }
    }
}
