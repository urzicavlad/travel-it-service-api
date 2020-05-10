package ro.ubbcluj.travelit.serviceapi.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Set;

@Data
public class City {

    private Long id;
    private String name;
    private String description;
    private Set<Recommendation> recommendations;

}
