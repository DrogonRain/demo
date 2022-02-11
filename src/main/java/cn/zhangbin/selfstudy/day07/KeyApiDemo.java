package cn.zhangbin.selfstudy.day07;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class KeyApiDemo {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("one",1);
        map.put("two",2);
        map.put("thr",3);
        System.out.println(map.containsKey("two"));
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iter = entries.iterator();
        while (iter.hasNext()){
            System.out.println(iter.next().toString());
        }
    }
}
