package com.api.product.services.mapper;

import com.api.product.entities.User;
import com.api.product.services.dto.UserDTO;
import java.util.List;

public interface UserMapper {
    UserDTO toDTO(User user);
    List<UserDTO> toDTOList(List<User> users);
    User toEntity(UserDTO dto);
}
