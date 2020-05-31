package ro.ubbcluj.travelit.serviceapi.controller.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Set;

@Data
@Accessors(chain = true)
public class CityDto {

    private long id;
    private String name;
    private String countryName;
    private String description;
    private Set<RecommendationDto> recommendations;

}
