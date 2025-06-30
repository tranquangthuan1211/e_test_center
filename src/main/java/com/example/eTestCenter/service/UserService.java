package com.example.eTestCenter.service;

import com.example.eTestCenter.Mapper.UserMapper;
import com.example.eTestCenter.dto.request.UserCreationalRequest;
import com.example.eTestCenter.entity.User;
import com.example.eTestCenter.enums.Role;
import com.example.eTestCenter.exception.AppException;
import com.example.eTestCenter.exception.ErrorCode;
import com.example.eTestCenter.repository.UserRepository;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
@Data
public class UserService {
    private UserRepository userRepository;
    private UserMapper userMapper;
    PasswordEncoder passwordEncoder;
    UserService(UserRepository userRepository,UserMapper userMapper,PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public User createuser(UserCreationalRequest request){
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new AppException(ErrorCode.USER_EXISTED);
        }
        User newUser = userMapper.toUser(request);

        var roles = new HashSet<String>();
        roles.add(Role.USER.name());
        newUser.setRoles(roles);
        newUser.setPassword(passwordEncoder.encode(request.getPassword()));

        return userRepository.save(newUser);
    }

    public User getUserByID(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTS));
    }

    public User updateUser(String id, User updatedUser) {
        return userRepository.findById(id).map(user -> {
            user.setName(updatedUser.getName());
            user.setPhone(updatedUser.getPhone());
            user.setEmail(updatedUser.getEmail());
            user.setRoles(updatedUser.getRoles());
            if (updatedUser.getPassword() != null) {
                user.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
            }
            return userRepository.save(user);
        }).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTS));
    }

    public void deleteUserById(String id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found with ID: " + id);
        }
        userRepository.deleteById(id);
    }
}
