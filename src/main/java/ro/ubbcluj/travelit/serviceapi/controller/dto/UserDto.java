package ro.ubbcluj.travelit.serviceapi.controller.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import ro.ubbcluj.travelit.serviceapi.model.Country;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@Accessors(chain = true)
public class UserDto {

    private Long id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @Email
    private String email;
    @NotNull
    private String username;
    @NotNull
    private String password;
    private String avatar;
    private String originCountry;
    private Set<Country> favouriteDestinations;
}
