package com.aaron.springinaction.knights.main;

import com.aaron.springinaction.knights.Knight;
import com.aaron.springinaction.knights.Minstrel;
import com.aaron.springinaction.knights.config.KnightConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class KinghtMain {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext("com.aaron.springinaction.knights");
        Knight kinght = ctx.getBean(Knight.class);
        kinght.embarkOnQuest();
    }
}
