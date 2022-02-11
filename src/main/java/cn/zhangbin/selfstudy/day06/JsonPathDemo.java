package cn.zhangbin.selfstudy.day06;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;

import java.util.HashMap;

public class JsonPathDemo {
    public static void main(String[] args) throws JsonProcessingException {
        String testJson = "{\"arrayList\":[\"A\",\"2\",\"3\"]}";
        ObjectMapper mapper = new ObjectMapper();
        HashMap responseJson = mapper.readValue(testJson,HashMap.class);

        int len = JsonPath.read(responseJson,"$.arrayList.length()");
        for (int i = 0; i < len; i++) {
            System.out.println("第"+(i+1)+"个元素的值为: "+JsonPath.read(responseJson,"$.arrayList["+i+"]"));
        }
    }

}
