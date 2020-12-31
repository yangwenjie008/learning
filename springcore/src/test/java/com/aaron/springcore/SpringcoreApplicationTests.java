package com.aaron.springcore;

import com.aaron.springcore.core.Animal;
import com.aaron.springcore.core.Cat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.Map;

@SpringBootTest
class SpringcoreApplicationTests {

    @Autowired
    private ApplicationContext context;

    @Autowired
    private Animal[] animals;

    @Autowired
    @Qualifier("dog")
    private Animal dog;

    @Test
    void contextLoads() {
        for(Animal animal : animals){
            animal.eat();
        }
    }

    @Test
    void testQualifier(){
        dog.eat();
    }

    @Test
    void testBF(){
        Map<String, Animal> map = context.getBeansOfType(Animal.class);
        map.forEach((k,v) ->{
            System.out.println(String.format("bean name is %s",k));
            v.eat();
        });
    }



}
