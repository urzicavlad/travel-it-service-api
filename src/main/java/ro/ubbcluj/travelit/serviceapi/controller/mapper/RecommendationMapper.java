package ro.ubbcluj.travelit.serviceapi.controller.mapper;

import ro.ubbcluj.travelit.serviceapi.controller.dto.RecommendationDto;
import ro.ubbcluj.travelit.serviceapi.controller.dto.UserDto;
import ro.ubbcluj.travelit.serviceapi.model.City;
import ro.ubbcluj.travelit.serviceapi.model.Recommendation;
import ro.ubbcluj.travelit.serviceapi.model.User;

public class RecommendationMapper {
    public static RecommendationDto mapToDto(final Recommendation recommendation) {
        RecommendationDto recommendationDto = new RecommendationDto()
                .setId(recommendation.getId())
                .setDescription(recommendation.getDescription())
                .setAddress(recommendation.getAddress())
                .setName(recommendation.getName());
        City city = recommendation.getCity();
        if (city != null){
            recommendationDto.setCityName(city.getName());
        }

        return recommendationDto;

    }

    public static Recommendation mapToEntity(final RecommendationDto recommendationDto) {
        return new Recommendation()
                .setId(recommendationDto.getId())
                .setName(recommendationDto.getName())
                .setAddress(recommendationDto.getAddress())
                .setDescription(recommendationDto.getDescription());
    }

}
