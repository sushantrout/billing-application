package com.tech.model.dto;

import lombok.Data;

@Data
public class BillingUserDTO {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String phone;
    private AddressDTO address;
}
