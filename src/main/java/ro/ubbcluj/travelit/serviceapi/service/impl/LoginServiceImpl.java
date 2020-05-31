package ro.ubbcluj.travelit.serviceapi.service.impl;

import org.springframework.stereotype.Service;
import ro.ubbcluj.travelit.serviceapi.model.User;
import ro.ubbcluj.travelit.serviceapi.service.LoginService;
import ro.ubbcluj.travelit.serviceapi.service.UserService;

@Service
public class LoginServiceImpl implements LoginService {

    private final UserService userService;

    public LoginServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public User login(String username, String password) {
        User user = userService.findByUsername(username);
        if (user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}
