package ro.ubbcluj.travelit.serviceapi.controller.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

@Data
@Accessors(chain = true)
public class AuthorizeDto {

    @NotNull
    private String username;
    @NotNull
    private String password;
}
