package com.aaron.springinaction.knights.config;

import com.aaron.springinaction.knights.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import javax.swing.*;

@Configuration
@EnableAspectJAutoProxy //step1. 启动aspect 自动代理
public class KnightConfig {

    @Bean
    public Knight knight(){
        Knight knight = new BraveKnight(quest());
        return knight;
    }



    @Bean
    public Quest quest(){
        Quest quest = new SlayDragOnQuest(System.out);
        return quest;
    }

    @Bean
    public Minstrel minstrel(){
        return new Minstrel(System.out);
    }




}
