package ro.ubbcluj.travelit.serviceapi.service.impl;

import org.passay.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ro.ubbcluj.travelit.serviceapi.model.User;
import ro.ubbcluj.travelit.serviceapi.repository.UserRepository;
import ro.ubbcluj.travelit.serviceapi.service.UserService;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
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
        return userRepository.save(encodePassword(verifyUser(user)));
    }

    @Override
    @Transactional
    public User changeRole(String userId , String role) {
        Optional<User> byUsername = userRepository.findById(Long.valueOf(userId));
        if (byUsername.isPresent()){
            int i = userRepository.updateRole(Long.valueOf(userId), role);
            if(i < 1){
                throw new RuntimeException("Can not update user!");
            }
        }else {
            throw new RuntimeException("User not Found!");
        }
        User user = byUsername.get();
        user.setRole(role);
        return user;
    }

    private User encodePassword(User verifiedUser) {
        final String encodedPassword = passwordEncoder.encode(verifiedUser.getPassword());
        return verifiedUser.setPassword(encodedPassword);
    }

    private User verifyUser(User user) {
        verifyUsername(user.getUsername());
        verifyEmail(user.getEmail());
        verifyPassword(user.getPassword());
        return user;
    }

    private void verifyUsername(String username) {
        if (userRepository.findByUsername(username).isPresent())
            throw new IllegalArgumentException("Username taken!, suggested username: " + suggestUsername(username));
    }

    private String suggestUsername(String username) {
        return username.concat(String.valueOf(new Random().nextInt(20)));
    }

    private void verifyEmail(String email) {
        if (userRepository.findByEmail(email).isPresent()) {
            throw new IllegalArgumentException("Email address already registered!");
        }

        try {
            new InternetAddress(email).validate();
        } catch (AddressException e) {
            throw new IllegalArgumentException("Invalid email address!");
        }
    }

    private void verifyPassword(String password) {
        final PasswordValidator validator = new PasswordValidator(getPasswordRules());
        final PasswordData passwordData = new PasswordData(password);
        final RuleResult result = validator.validate(passwordData);

        if (!result.isValid()) {
            final String errorsOnPassword = result.getDetails().stream()
                    .map(RuleResultDetail::getErrorCode)
                    .collect(Collectors.toList())
                    .toString();
            throw new IllegalArgumentException("Password is not valid : " + errorsOnPassword);
        }
    }

    private List<Rule> getPasswordRules() {
        List<Rule> rules = new ArrayList<>();
        rules.add(new LengthRule(8, 100));
        rules.add(new WhitespaceRule());
        rules.add(new CharacterRule(EnglishCharacterData.UpperCase, 1));
        rules.add(new CharacterRule(EnglishCharacterData.LowerCase, 1));
        rules.add(new CharacterRule(EnglishCharacterData.Digit, 1));
        rules.add(new CharacterRule(EnglishCharacterData.Special, 1));
        return rules;
    }

    @Override
    public User getByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("User not found!"));
    }

    @Override
    public Boolean userExist(String username) {
        return userRepository.findByUsername(username).isPresent();
    }
}
