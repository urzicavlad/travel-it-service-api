package ro.ubbcluj.travelit.serviceapi.controller.mapper;

import ro.ubbcluj.travelit.serviceapi.controller.dto.CityDto;
import ro.ubbcluj.travelit.serviceapi.controller.dto.RecommendationDto;
import ro.ubbcluj.travelit.serviceapi.model.City;
import ro.ubbcluj.travelit.serviceapi.model.Recommendation;

public class RecommendationMapper {
    public static RecommendationDto mapToDto(final Recommendation recommendation) {
        return new RecommendationDto()
                .setId(recommendation.getId());
    }

//    public static City mapToEntity(final CityDto cityDto) {
//        return new City()
//
//    }
}
