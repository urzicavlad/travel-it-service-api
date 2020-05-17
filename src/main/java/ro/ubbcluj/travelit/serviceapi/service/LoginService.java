package ro.ubbcluj.travelit.serviceapi.service;

import ro.ubbcluj.travelit.serviceapi.model.User;

public interface LoginService {

    User login(String username, String password);
}
