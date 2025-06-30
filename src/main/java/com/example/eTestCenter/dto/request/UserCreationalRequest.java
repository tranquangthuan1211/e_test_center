package com.example.eTestCenter.dto.request;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class UserCreationalRequest {
    private String id;
    private String name;
    private String phone;
    private String dob;
    private String email;
    private String description;
    private String password;
    Set<String> roles;

}
