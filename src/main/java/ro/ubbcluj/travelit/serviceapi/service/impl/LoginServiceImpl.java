package ro.ubbcluj.travelit.serviceapi.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ro.ubbcluj.travelit.serviceapi.model.User;
import ro.ubbcluj.travelit.serviceapi.service.LoginService;
import ro.ubbcluj.travelit.serviceapi.service.UserService;

@Service
public class LoginServiceImpl implements LoginService {

    private final UserService userService;

    private final PasswordEncoder passwordEncoder;

    public LoginServiceImpl(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User login(String username, String password) {
        User user = userService.getByUsername(username);
        if (passwordEncoder.matches(password, user.getPassword())) {
            return user;
        }
        throw new RuntimeException("Password is invalid!");
    }
}
