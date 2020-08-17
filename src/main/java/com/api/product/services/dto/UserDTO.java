package com.api.product.services.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserDTO {
    private String username;
    private String fullname;
    private Date birthDay;
    private String phoneNumber;
    private String address;
}
