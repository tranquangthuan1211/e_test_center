package com.example.eTestCenter.Mapper;

import com.example.eTestCenter.dto.request.UserCreationalRequest;
import com.example.eTestCenter.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationalRequest request);
}
