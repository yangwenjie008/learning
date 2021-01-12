package com.aaron.springinaction;

import com.aaron.springinaction.knights.Knight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class SpringInActionApplication implements CommandLineRunner, ApplicationRunner {

    @Autowired
    private  Knight knight;



    public static void main(String[] args) {
        SpringApplication.run(SpringInActionApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        knight.embarkOnQuest();
        Arrays.stream(args).forEach(arg -> System.out.println(arg));

    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        knight.embarkOnQuest();
        args.getNonOptionArgs().stream().forEachOrdered(arg -> System.out.println(arg));
    }
}
