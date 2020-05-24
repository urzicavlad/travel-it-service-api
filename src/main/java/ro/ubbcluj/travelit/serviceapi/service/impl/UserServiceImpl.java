package ro.ubbcluj.travelit.serviceapi.service.impl;

import org.passay.*;
import org.springframework.stereotype.Service;
import ro.ubbcluj.travelit.serviceapi.model.User;
import ro.ubbcluj.travelit.serviceapi.repository.UserRepository;
import ro.ubbcluj.travelit.serviceapi.service.UserService;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.util.ArrayList;
import java.util.List;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.LengthRule;
import org.passay.PasswordData;
import org.passay.PasswordValidator;
import org.passay.RuleResult;
import org.passay.WhitespaceRule;

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
        if (userRepository.findByUsername(user.getUsername()).isPresent())
            throw new IllegalArgumentException("Username taken!");

        if (userRepository.findByEmail(user.getEmail()).isPresent())
            throw new IllegalArgumentException("Email address already registered!");

        try {
            InternetAddress email = new InternetAddress(user.getEmail());
            email.validate();
        } catch (AddressException e) {
            throw new IllegalArgumentException("Invalid email address!");
        }

        List<Rule> rules = new ArrayList<>();
        rules.add(new LengthRule(8, 20));
        rules.add(new WhitespaceRule());
        rules.add(new CharacterRule(EnglishCharacterData.UpperCase, 1));
        rules.add(new CharacterRule(EnglishCharacterData.LowerCase, 1));
        rules.add(new CharacterRule(EnglishCharacterData.Digit, 1));
        rules.add(new CharacterRule(EnglishCharacterData.Special, 1));

        PasswordValidator validator = new PasswordValidator(rules);
        PasswordData password = new PasswordData(user.getPassword());
        RuleResult result = validator.validate(password);

        if(!result.isValid())
            throw new IllegalArgumentException("Password contain at least one digit, one upper and lower character, one special character and should contain between 8-20 characters. Please avoid tab and space!");

        return userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("User not found!"));
    }
}
