package com.example.eTestCenter.controller;

import com.example.eTestCenter.dto.request.UserCreationalRequest;
import com.example.eTestCenter.dto.response.ApiResponse;
import com.example.eTestCenter.entity.User;
import com.example.eTestCenter.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;
    UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    ApiResponse<User> createUser(@RequestBody UserCreationalRequest request){
        return ApiResponse.<User>builder()
                .data(userService.createuser(request))
                .code(200)
                .message("create user successfully")
                .build();
    }
    @GetMapping("/{userId}")
    public ApiResponse<User> getUser(@PathVariable("userId") String userId) {
        User user = userService.getUserByID(userId);
        return ApiResponse.<User>builder()
                .code(200)
                .message("get user successfully")
                .data(user)
                .build();
    }
    @PutMapping("/{userId}")
    public ApiResponse<User> updateUser(@PathVariable String userId, @RequestBody User user) {
        User updated = userService.updateUser(userId, user);
        return ApiResponse.<User>builder()
                .code(200)
                .message("update successfully")
                .data(updated)
                .build();
    }
    @DeleteMapping("/{userId}")
    public ApiResponse<Void> deletedUser(@PathVariable String userId){
        userService.deleteUserById(userId);
        return ApiResponse.<Void>builder()
                .message("deleted user successfully")
                .code(200)
                .build();
    }
}
