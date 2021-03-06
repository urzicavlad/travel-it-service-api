package ro.ubbcluj.travelit.serviceapi.service;

import ro.ubbcluj.travelit.serviceapi.model.User;

import java.util.Arrays;
import java.util.List;

public interface UserService {

    List<User> getAll();

    User getById(Long id);

    User save(User user);

    User changeRole(String username, String role);

    User getByUsername(String username);

    Boolean userExist(String username);

}
