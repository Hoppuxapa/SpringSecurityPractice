package com.kravchuk.SpringSecurityPractice;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

import javax.jdo.annotations.Join;

@EnableAspectJAutoProxy
@SpringBootApplication(scanBasePackages = "com.kravchuk")
@PropertySource("classpath:application.properties")
@Join
public class SpringSecurityPracticeApplication {
    @Join
    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityPracticeApplication.class, args);

    }

}
