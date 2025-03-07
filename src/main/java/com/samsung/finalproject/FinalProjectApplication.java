package com.samsung.finalproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class FinalProjectApplication {

    public static void main(String[] args) {
//        PasswordEncoder enconder = new BCryptPasswordEncoder();
//        System.out.println(enconder.encode("password"));
        SpringApplication.run(FinalProjectApplication.class, args);
    }



}
