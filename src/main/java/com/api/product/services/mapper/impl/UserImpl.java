package com.api.product.services.mapper.impl;

import com.api.product.entities.User;
import com.api.product.services.dto.UserDTO;
import com.api.product.services.mapper.UserMapper;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserImpl implements UserMapper {
    @Override
    public UserDTO toDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setAddress(user.getAddress());
        dto.setBirthDay(user.getBirthDay());
        dto.setPhoneNumber(user.getPhoneNumber());
        dto.setFullname(user.getFullname());
        dto.setUsername(user.getUsername());
        return dto;
    }

    @Override
    public List<UserDTO> toDTOList(List<User> users) {
        List<UserDTO> userDTOS = new ArrayList<>();
        for (User item : users){
            userDTOS.add(toDTO(item));
        }
        return userDTOS;
    }

    @Override
    public User toEntity(UserDTO dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setAddress(dto.getAddress());
        user.setBirthDay(dto.getBirthDay());
        user.setFullname(dto.getFullname());
        user.setPhoneNumber(dto.getPhoneNumber());
        return user;
    }
}
