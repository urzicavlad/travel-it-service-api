package ro.ubbcluj.travelit.serviceapi.controller.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class RecommendationDto {

    private long id;
    private String name;
    private String address;
    private String description;
}
