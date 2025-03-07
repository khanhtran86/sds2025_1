package com.samsung.jwtauthen;

import com.samsung.jwtauthen.common.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JwtauthenApplication {
    public static void main(String[] args) {
        JwtUtil jwtUtil = new JwtUtil();
        String token = jwtUtil.generateToken("khanh.tx@gmail.com");
        System.out.println(token);


        SpringApplication.run(JwtauthenApplication.class, args);
    }

}
