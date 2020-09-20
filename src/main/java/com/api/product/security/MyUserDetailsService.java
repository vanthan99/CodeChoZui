package com.api.product.security;

import com.api.product.entities.User;
import com.api.product.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MyUserDetailsService implements UserDetailsService {
    private final UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findUserByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException("could not find user");
        }
        return new MyUserDetails(user);
    }
}
