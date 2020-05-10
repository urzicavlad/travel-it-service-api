package ro.ubbcluj.travelit.serviceapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Set;

@Data
public class Country {

    private Long id;
    private String name;
    @JsonIgnore
    private String code;
    private String flag;
    private Set<City> cities;

}
