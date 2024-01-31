package com.bci.bciintegration.services;

import com.bci.bciintegration.dto.SignupRequest;
import com.bci.bciintegration.dto.UserResponse;
import com.bci.bciintegration.exceptions.UserExistsException;
import com.bci.bciintegration.models.User;
import com.bci.bciintegration.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService{
    @Autowired
    private IUserRepository _userRepository;
    @Autowired
    private JwtTokenService _jwtTokenService;

    @Override
    public User save(SignupRequest signupRequest) throws UserExistsException{
        if (_userRepository.existsByEmail(signupRequest.getEmail())) {
            throw new UserExistsException("El correo ya registrado");
        }
        User user = new User();
        user.setName(signupRequest.getName());
        user.setEmail(signupRequest.getEmail());
        user.setPassword(signupRequest.getPassword());
        user.setPhones(signupRequest.getPhones());
        user.setActive(true);
        user.setToken(_jwtTokenService.generateToken(user));
        return _userRepository.save(user);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return _userRepository.existsByEmail(email);
    }

    @Override
    public List<UserResponse> findAll() {
        return ((ArrayList<User>)_userRepository.findAll()).stream()
                .map(user-> {
                    UserResponse response = new UserResponse();
                    response.setId(user.getId());
                    response.setName(user.getName());
                    response.setEmail(user.getEmail());
                    response.setToken(user.getToken());
                    response.setActive(user.getActive());
                    response.setPhones(user.getPhones());
                    return response;
                }).collect(Collectors.toList());
    }
}
