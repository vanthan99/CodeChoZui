package com.api.product.mapper;

import com.api.product.entities.User;
import com.api.product.dto.UserDTO;
import java.util.List;

public interface UserMapper {
    UserDTO toDTO(User user);
    List<UserDTO> toDTOList(List<User> users);
    User toEntity(UserDTO dto);
}
