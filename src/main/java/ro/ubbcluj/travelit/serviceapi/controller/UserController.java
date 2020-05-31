package ro.ubbcluj.travelit.serviceapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ubbcluj.travelit.serviceapi.controller.dto.UserDto;
import ro.ubbcluj.travelit.serviceapi.controller.mapper.UserMapper;
import ro.ubbcluj.travelit.serviceapi.service.UserService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = {"*"})
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserDto add(@Valid @RequestBody UserDto userDto) {
        return UserMapper.mapToDto(userService.save(UserMapper.mapToEntity(userDto)));
    }

    @GetMapping
    public List<UserDto> getAll() {
        return userService.getAll()
                .stream()
                .map(UserMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/filter")
    public UserDto getUserByUsername(@RequestParam String username) {
        return UserMapper.mapToDto(userService.getByUsername(username));
    }

    @RequestMapping(method = RequestMethod.HEAD, path = "/{username}")
    @CrossOrigin(origins = {"*"})
    public ResponseEntity<String> usernameExist(@PathVariable String username) {
        return userService.userExist(username)
                ? ResponseEntity.status(HttpStatus.OK).build()
                : ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    }

}
