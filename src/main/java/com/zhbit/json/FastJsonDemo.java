package com.zhbit.json;

import com.alibaba.fastjson.JSON;
import com.zhbit.pojo.User;

public class FastJsonDemo
{
    public static void main(String[] args) {
        //1. 将java对象转为json
        User user = new User();
        user.setId(1);
        user.setUsername("zhangsan");
        user.setPassword("123456");
        String s = JSON.toJSONString(user);
        System.out.println(s);

//        2.将json转为java对象
        User user2 = JSON.parseObject("{\"id\":2,\"password\":\"23456\",\"username\":\"lisi\"}", User.class);
        System.out.println(user2 );

    }
}
