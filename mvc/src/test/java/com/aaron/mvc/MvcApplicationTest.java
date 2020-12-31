package com.aaron.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.text.NumberFormat;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MvcApplicationTest {
    @Autowired
    private ApplicationContext ctx;

    @Qualifier("defaultNumberFormat")
    @Autowired
    private NumberFormat nf;

    @Test
    void contextLoads() {

        System.out.printf("加载%d个bean%n", ctx.getBeanDefinitionCount());

        String[] names = ctx.getBeanDefinitionNames();
        for(String name: names){
            System.out.println(name);
        }
    }

    @Test
    void defaultNumberFormat(){
        BigDecimal num = new BigDecimal("27783489127.27378673");
        System.out.println(nf.format(num));
    }

    @Test
    void germanyNumberFormat(){
        NumberFormat gynf = (NumberFormat) ctx.getBean("germanyNumberFormat");
        BigDecimal num = new BigDecimal("27783489127.27378673");
        System.out.println(gynf.format(num));
    }

}