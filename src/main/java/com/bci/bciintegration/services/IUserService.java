package com.bci.bciintegration.services;

import com.bci.bciintegration.dto.SignupRequest;
import com.bci.bciintegration.dto.UserResponse;
import com.bci.bciintegration.exceptions.UserExistsException;
import com.bci.bciintegration.models.User;

import java.util.List;

public interface IUserService {
    User save(SignupRequest user) throws UserExistsException;
    Boolean existsByEmail(String email);
    List<UserResponse> findAll();
}
