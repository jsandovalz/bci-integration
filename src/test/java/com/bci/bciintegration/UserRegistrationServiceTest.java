package com.bci.bciintegration;

import com.bci.bciintegration.dto.SignupRequest;
import com.bci.bciintegration.models.User;
import com.bci.bciintegration.repository.IUserRepository;
import com.bci.bciintegration.services.IUserService;
import com.bci.bciintegration.services.JwtTokenService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class UserRegistrationServiceTest {
    @Mock
    private IUserRepository userRepository;

    @Mock
    private IUserService userService;

    @Mock
    private Environment env;

    @InjectMocks
    private JwtTokenService jwtTokenService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRegisterUser() {
        User user = new User();
        user.setName("test");
        user.setPassword("password");
        user.setEmail("email@email.com");

        when(userRepository.save(any(User.class))).thenReturn(user);

        User result = userRepository.save(user);

        verify(userRepository).save(any(User.class));
        assertEquals(result.getName(), "test");
        assertEquals(result.getPassword(), "password");
    }
    @Test()
    public void testRegisterUser_UserExists() {
        when(userRepository.existsByEmail("email@email.com")).thenReturn(true);
        SignupRequest user = new SignupRequest();
        user.setName("test");
        user.setPassword("password");
        user.setEmail("email@email.com");
        assertTrue(userRepository.existsByEmail("email@email.com"));
    }
    @Test
    public void whenGetUsers_thenReturnUserList() {
        User user1 = new User();
        user1.setName("test");
        user1.setEmail("test@email.com");

        User user2 = new User();
        user2.setName("test2");
        user2.setEmail("test2@email.com");
        List<User> users = Arrays.asList(user1, user2);

        when(userRepository.findAll()).thenReturn(users);

        List<User> foundUsers = (List<User>) userRepository.findAll();

        assertEquals(2, foundUsers.size());
        assertEquals(user1, foundUsers.get(0));
        assertEquals(user2, foundUsers.get(1));
    }
}
