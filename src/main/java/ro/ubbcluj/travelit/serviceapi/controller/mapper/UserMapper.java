package ro.ubbcluj.travelit.serviceapi.controller.mapper;

import ro.ubbcluj.travelit.serviceapi.controller.dto.UserDto;
import ro.ubbcluj.travelit.serviceapi.model.User;

public class UserMapper {

    public static UserDto mapToDto(final User user) {
        return new UserDto()
                .setId(user.getId())
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setEmail(user.getEmail())
                .setUsername(user.getUsername())
                .setPassword(user.getPassword())
                .setAvatar(user.getAvatar())
                .setOriginCountry(user.getOriginCountry())
                .setRole(user.getRole())
                .setFavouriteDestinations(user.getFavouriteDestinations());
    }

    public static User mapToEntity(final UserDto userDto) {
        return new User()
                .setId(userDto.getId())
                .setFirstName(userDto.getFirstName())
                .setLastName(userDto.getLastName())
                .setEmail(userDto.getEmail())
                .setUsername(userDto.getUsername())
                .setPassword(userDto.getPassword())
                .setAvatar(userDto.getAvatar())
                .setOriginCountry(userDto.getOriginCountry())
                .setRole("USER")
                .setFavouriteDestinations(userDto.getFavouriteDestinations());
    }
}
