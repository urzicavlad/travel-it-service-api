package ro.ubbcluj.travelit.serviceapi.controller;

import org.springframework.web.bind.annotation.*;
import ro.ubbcluj.travelit.serviceapi.controller.dto.AuthorizeDto;
import ro.ubbcluj.travelit.serviceapi.controller.dto.UserDto;
import ro.ubbcluj.travelit.serviceapi.controller.mapper.UserMapper;
import ro.ubbcluj.travelit.serviceapi.service.LoginService;

import javax.validation.Valid;

@RestController
@RequestMapping("/authorize")
@CrossOrigin(origins = {"*"})
public class AuthorizeController {

    private LoginService loginService;

    public AuthorizeController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public UserDto login(@Valid @RequestBody AuthorizeDto authorizeDto) {
        return UserMapper.mapToDto(loginService.login(authorizeDto.getUsername(), authorizeDto.getPassword()));
    }
}
