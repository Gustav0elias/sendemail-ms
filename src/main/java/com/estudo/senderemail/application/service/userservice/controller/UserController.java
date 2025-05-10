package com.estudo.senderemail.application.service.userservice.controller;

import com.estudo.senderemail.application.dto.Request.CreateUserRequest;
import com.estudo.senderemail.application.dto.Response.UserResponse;
import com.estudo.senderemail.application.service.userservice.facade.UserServiceFacade;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceFacade userServiceFacade;

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody CreateUserRequest request) {
        UserResponse response = userServiceFacade.createUser(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Page<UserResponse>> getUsers(Pageable pageable) {
        Page<UserResponse> response = userServiceFacade.getUsers(pageable);
        return ResponseEntity.ok(response);
    }
} 