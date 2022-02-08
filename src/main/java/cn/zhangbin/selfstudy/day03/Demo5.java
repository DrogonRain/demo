package cn.zhangbin.selfstudy.day03;

import java.util.Arrays;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo5 {
    //创建random
    private static Random random = new Random();

    public static void main(String[] args) {
        //生成5个1~30之间的随机整数
        int[] rand = new int[5];
        for (int i = 0; i < rand.length; i++) {
            rand[i] = random.nextInt(29)+1;
        }
        System.out.println(Arrays.toString(rand));
        String str = "1321421@qq.com";
        System.out.println(isEmail(str));
        int num = 1000;
        int[] sum = count(num);
        System.out.println("出现正面的次数为: "+sum[0]+",背面的次数为: "+sum[1]);
        String ip = "192.169.0.0";
        System.out.println(isIp(ip));
        String html = "<font face=\"Arial,Serif\" size=\"+2\" color=\"red\">";
        String regex = "\\w+=\"[a-zA-Z0-9,\\+]+\"";
        Matcher matcher = Pattern.compile(regex).matcher(html); // 编译regex表达式并与变量进行匹配
        while (matcher.find()){
            String[] strings = matcher.group(0).split("=");
            System.out.println(strings[0] + "\t" + strings[1].replaceAll("\""," "));
        }
    }

    private static boolean isEmail(String str){
        if (str.length()==0 || "".equals(str) || str == null){
            return false;
        }
        String regix = "\\w+@\\w+\\.\\w+"; // 输入正则表达式
        return str.matches(regix); // 进行匹配验证结果并返回
    }

    private static boolean isIp(String ip){
        if (ip.length()==0 || ip == null){
            return false;
        }
        String regex = "([12]?[0-9]?[0-9]?\\.){3}[12]?[0-9]?[0-9]?";
        return ip.matches(regex);
    }

    private static int[] count(int num){
        int s = 0;
        int[] sum = new int[2];
        //根据次数进行循环
        for (int i = 0; i < num; i++) {
            s = random.nextInt(2);
            if (s == 0){
                sum[0]++;
            }else {
                sum[1]++;
            }
        }
        return sum;
    }
}
