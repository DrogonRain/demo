package cn.zhangbin.selfstudy.thread;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

class MyMath{
    private MyMath(){}
    public static double round(double num,int scale){// num数字, scale保留位数
//        return Math.round(num * Math.pow(10,scale)) / Math.pow(10,scale);//自定义四舍五入
        return new BigDecimal(num).divide(new BigDecimal(1.0),scale, RoundingMode.HALF_UP).doubleValue();//自定义四舍五入
    }
}
public class MathDemo {
    public static void main(String[] args) throws ParseException {
        double num = 11.455;
        System.out.println(MyMath.round(num,2));
        Random random = new Random();
        System.out.println(random.nextInt(9)+1);
        BigInteger bigA = new BigInteger("222222222222222222222222222222222222222");
        BigInteger bigB = new BigInteger("22132143121321");
        System.out.println("加法操作："+bigA.add(bigB));
        System.out.println("减法操作："+bigA.subtract(bigB));
        System.out.println("乘法操作："+bigA.multiply(bigB));
        System.out.println("除法操作："+bigA.divide(bigB));
        BigInteger result [] = bigA.divideAndRemainder(bigB);
        System.out.println("商: "+result[0]+"余数: "+result[1]);
        Date date = new Date();
        System.out.println(date.getTime());
        long current = date.getTime();
        current += 864000 * 1000;
        date = new Date(current);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = format.format(date);
        System.out.println(str);
        String bitrh = "2000-07-21 11:23:21";
        Date date1 = format.parse(bitrh);
        System.out.println(date1);
        double money = 2132141231.2312;
        String str4 = NumberFormat.getInstance().format(money);
        System.out.println(str4);
    }
}
