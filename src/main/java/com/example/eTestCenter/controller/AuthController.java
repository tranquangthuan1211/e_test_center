package com.example.eTestCenter.controller;

import com.example.eTestCenter.dto.request.AuthenticationRequest;
import com.example.eTestCenter.dto.request.UserCreationalRequest;
import com.example.eTestCenter.dto.response.ApiResponse;
import com.example.eTestCenter.dto.response.AuthenticationResponse;
import com.example.eTestCenter.entity.User;
import com.example.eTestCenter.service.AuthService;
import com.example.eTestCenter.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping // Không cần base path vì đã có trong Security config
@Tag(name = "Authentication", description = "APIs for user authentication and registration")
public class AuthController {

    private final AuthService authService;
    private final UserService userService;

    public AuthController(AuthService authService, UserService userService) {
        this.authService = authService;
        this.userService = userService;
    }

    @Operation(
            summary = "User Login",
            description = "Authenticate user and return JWT token"
    )
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "200",
                    description = "Login successful",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = AuthenticationResponse.class)
                    )
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "401",
                    description = "Invalid credentials"
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "400",
                    description = "Bad request"
            )
    })
    @PostMapping("/logins")
    public ResponseEntity<AuthenticationResponse> login(
            @Valid @RequestBody AuthenticationRequest request) {

        AuthenticationResponse response = authService.authenticate(request);
        return ResponseEntity.ok(response);
    }

    @Operation(
            summary = "User Registration",
            description = "Register a new user account"
    )
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "200",
                    description = "Registration successful",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ApiResponse.class)
                    )
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "400",
                    description = "Invalid input data"
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "409",
                    description = "User already exists"
            )
    })
    @PostMapping("/registers")
    public ResponseEntity<ApiResponse<User>> register(
            @Valid @RequestBody UserCreationalRequest request) {

        User createdUser = userService.createuser(request);

        ApiResponse<User> response = ApiResponse.<User>builder()
                .message("Registration successful")
                .data(createdUser)
                .code(200)
                .build();

        return ResponseEntity.ok(response);
    }
}