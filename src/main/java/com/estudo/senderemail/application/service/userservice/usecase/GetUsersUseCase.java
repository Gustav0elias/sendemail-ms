package com.estudo.senderemail.application.service.userservice.usecase;

import com.estudo.senderemail.application.dto.Response.UserResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GetUsersUseCase {
    Page<UserResponse> getUsers(Pageable pageable);
} 