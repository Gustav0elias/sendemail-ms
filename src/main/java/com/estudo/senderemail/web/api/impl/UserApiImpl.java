package com.estudo.senderemail.web.api.impl;

import com.estudo.senderemail.application.dto.Request.CreateUserRequest;
import com.estudo.senderemail.application.dto.Response.UserResponse;
import com.estudo.senderemail.application.facede.UserServiceFacade;
import com.estudo.senderemail.web.api.UserApi;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserApiImpl implements UserApi {

    private final UserServiceFacade userServiceFacade;

    @Override
    public ResponseEntity<UserResponse> createUser(CreateUserRequest request) {
        UserResponse response = userServiceFacade.createUser(request);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Page<UserResponse>> getUsers(Pageable pageable) {
        Page<UserResponse> response = userServiceFacade.getUsers(pageable);
        return ResponseEntity.ok(response);
    }
} 