package com.api.product.security;

import com.api.product.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class LoginController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping("/login")
    public LoginResponse authenticateUser(@RequestBody LoginRequest loginRequest) {

        System.out.println("da vao login");
        // Xác thực từ username và password.
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        // Nếu không xảy ra exception tức là thông tin hợp lệ
        // Set thông tin authentication vào Security Context
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Trả về jwt cho người dùng.
        String jwt = jwtTokenProvider.generateToken((MyUserDetails) authentication.getPrincipal());
        return new LoginResponse(jwt);
    }
}
