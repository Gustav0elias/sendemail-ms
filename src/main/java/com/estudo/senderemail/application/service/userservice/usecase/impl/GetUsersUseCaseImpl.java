package com.estudo.senderemail.application.service.userservice.usecase.impl;

import com.estudo.senderemail.application.dto.Response.UserResponse;
import com.estudo.senderemail.application.mapper.UserMapper;
import com.estudo.senderemail.application.service.userservice.usecase.GetUsersUseCase;
import com.estudo.senderemail.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetUsersUseCaseImpl implements GetUsersUseCase {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public Page<UserResponse> getUsers(Pageable pageable) {
        return userRepository.findAll(pageable)
                .map(userMapper::toDto);
    }
} 