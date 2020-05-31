package ro.ubbcluj.travelit.serviceapi.controller.mapper;

import ro.ubbcluj.travelit.serviceapi.controller.dto.RecommendationDto;
import ro.ubbcluj.travelit.serviceapi.model.Recommendation;

public class RecommendationMapper {
    public static RecommendationDto mapToDto(final Recommendation recommendation) {
        return new RecommendationDto()
                .setId(recommendation.getId())
                .setDescription(recommendation.getDescription())
                .setAddress(recommendation.getAddress())
                .setName(recommendation.getName());

    }

}
