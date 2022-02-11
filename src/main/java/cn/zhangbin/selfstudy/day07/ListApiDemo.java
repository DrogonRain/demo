package cn.zhangbin.selfstudy.day07;

import java.util.*;

public class ListApiDemo {
    public static void main(String[] args) {
        /**
         * 迭代输出(首选) Iterator
         *  PS: 若在迭代过程中使用Collection中的remove对数组进行数据删除
         *      则会导致 java.util.ConcurrentModificationException 并发操作异常
         *      因此执行删除使用Iterator中的remove方法
         *  Collection与Iterator中的remove方法区别:
         *      在进行迭代输出的时候如果使用Collection中的remove则会造成并发更新异常,Iterator中的remove则正常进行删除操作
         */
        List<String> list = new ArrayList<String>();
        list.add("demo1");
        list.add("demo2");
        list.add("demo3");
        list.add("demo4");
        Iterator<String> iter = list.iterator(); // 实例化Iterator对象
        while (iter.hasNext()) {
            String str = iter.next();
            if ("demo3".equals(str)) {
//                list.remove(str); 抛出异常 ConcurrentModificationException
                iter.remove();
            } else {
                System.out.println(str);
            }
        }
        /**
         * 双向迭代输出 : ListIterator
         */
        ListIterator<String> iter2 = list.listIterator(); // 实例化ListIterator对象
        System.out.print("由前向后: ");
        while (iter2.hasNext()){
            String str = iter2.next();
            System.out.print(str+" ");
        }
        System.out.print("\n");
        System.out.print("由后向前: ");
        while (iter2.hasPrevious()){
            String str = iter2.previous();
            System.out.print(str+" ");
        }
        System.out.print("\n");
        /**
         * Enumeration迭代输出,仅为Vector一个类服务
         */
        Vector<String> vector = new Vector<String>();
        vector.add("demo1");
        vector.add("demo2");
        vector.add("demo3");
        Enumeration<String> enu = vector.elements();
        while (enu.hasMoreElements()){
            System.out.print(enu.nextElement()+" ");
        }
        System.out.print("\n");
        /**
         * forEach循环
         */
        for (String str : list) {
            System.out.print(str+" ");
        }
    }
}
