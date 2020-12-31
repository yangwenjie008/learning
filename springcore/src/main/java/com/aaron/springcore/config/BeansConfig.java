package com.aaron.springcore.config;

import com.aaron.springcore.core.Animal;
import com.aaron.springcore.core.Cat;
import com.aaron.springcore.core.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    @Bean(initMethod = "init")
    public Animal cat(){
        return new Cat();
    }

    @Bean
    public Animal dog(){
        return new Dog();
    }




}
