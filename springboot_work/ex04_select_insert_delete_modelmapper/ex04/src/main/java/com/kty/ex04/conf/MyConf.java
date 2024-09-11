package com.kty.ex04.conf;

import com.kty.ex04.obj.AA;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.kty.ex04.obj")
public class MyConf {

    @Bean
    public AA aa() {
        return new AA();
    }

//    @Bean
//    public BB bb() {
//        return new BB();
//    }

}
