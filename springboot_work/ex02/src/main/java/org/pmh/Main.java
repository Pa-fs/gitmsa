package org.pmh;

import org.pmh.components.AA;
import org.pmh.conf.MyConf;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(MyConf.class);

        Arrays.stream(applicationContext.getBeanDefinitionNames())
                .forEach(System.out::println);

        AA aa = applicationContext.getBean(AA.class);
        AA aa1 = applicationContext.getBean(AA.class);
        System.out.println(aa);
        System.out.println(aa1);
        System.out.println(aa == aa1);

        AA aa2 = new AA();
        AA aa3 = new AA();

        aa1.setName("스프링 통안에 있는 객체");

        System.out.println("aa = " + aa);
        System.out.println("aa1 = " + aa1);
        System.out.println("aa2 = " + aa2);
        System.out.println("aa3 = " + aa3);
    }
}