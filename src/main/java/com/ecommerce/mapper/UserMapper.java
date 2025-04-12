package com.ecommerce.mapper;

import com.ecommerce.model.UserRegisterRequest;
import com.ecommerce.persistence.entity.User;
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
