package com.api.product.security;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
