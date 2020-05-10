package ro.ubbcluj.travelit.serviceapi.model;

import lombok.Data;

@Data
public class Recommendation {

    private Long id;
    private String name;
    private String address;
    private String description;

}
