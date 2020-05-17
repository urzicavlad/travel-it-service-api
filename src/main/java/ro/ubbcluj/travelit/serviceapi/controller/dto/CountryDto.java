package ro.ubbcluj.travelit.serviceapi.controller.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CountryDto {

    private Long id;
    private String name;
    private String code;
    private String flag;

}
