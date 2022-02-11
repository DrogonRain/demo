package cn.zhangbin.selfstudy.day06;

import java.util.regex.Pattern;

public class PatternDemo {
    public static void main(String[] args) {
        String content = "https://www.tensorflow.org/";

        String patternA = "[a-z]+://[a-z.]+/";
        String patternB = "https[://]www[.]tensorflow[.]org[/]";
        String patternC = "[htps]+://www.tensorflow.org/";
        String patternD = "[a-zA-Z.:/]+";

        System.out.println(Pattern.matches(patternA, content)); // true
        System.out.println(Pattern.matches(patternB, content)); // false
        System.out.println(Pattern.matches(patternC, content)); // true
        System.out.println(Pattern.matches(patternD, content)); // true
        System.out.println(content instanceof String);
    }
}
