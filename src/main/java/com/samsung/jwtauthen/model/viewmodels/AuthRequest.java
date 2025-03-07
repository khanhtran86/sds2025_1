package com.samsung.jwtauthen.model.viewmodels;

import lombok.Data;

@Data
public class AuthRequest {
    private String username;
    private String password;
}
