package com.api.product.repositories;

import com.api.product.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,String> {
    @Query("select u from User u where u.username=:username and u.enable=true")
    User findUserByUsername(String username);
}
