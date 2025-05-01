package com.ecommerce.user.mapper;

import com.ecommerce.user.model.UserRegisterRequest;
import com.ecommerce.user.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User fromRegisterDto(UserRegisterRequest userRegisterRequestDto) {
        User user = new User();
        user.setEmail(userRegisterRequestDto.getEmail());
        user.setPassword(userRegisterRequestDto.getPassword());
        user.setPhoneNumber(userRegisterRequestDto.getPhoneNumber());
        user.setRole(userRegisterRequestDto.getRole());
        user.setPhoneVerified(false); // default on registration
        return user;
    }
}
