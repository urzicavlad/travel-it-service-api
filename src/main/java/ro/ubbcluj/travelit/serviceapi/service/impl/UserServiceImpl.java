package ro.ubbcluj.travelit.serviceapi.service.impl;

import org.springframework.stereotype.Service;
import ro.ubbcluj.travelit.serviceapi.model.User;
import ro.ubbcluj.travelit.serviceapi.repository.UserRepository;
import ro.ubbcluj.travelit.serviceapi.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found!"));
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("User not found!"));
    }
}
