package org.zjy;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.zjy.dao.TUserMapper;
import org.zjy.entity.TUser;

import java.io.IOException;

public class ProviderRunner {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println(context.getDisplayName() + ": here");
        context.start();
        System.out.println("服务已经启动...");
        System.in.read();
    }
}
