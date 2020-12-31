package com.aaron.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.NumberFormat;
import java.util.Locale;

@SpringBootApplication
public class MvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(MvcApplication.class, args);
    }

    @Bean
    public NumberFormat defaultNumberFormat(){
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        return numberFormat;
    }

    @Bean
    public NumberFormat germanyNumberFormat(){
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.GERMANY);
        return numberFormat;
    }

}
