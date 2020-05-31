package ro.ubbcluj.travelit.serviceapi.controller.mapper;

import ro.ubbcluj.travelit.serviceapi.controller.dto.CityDto;
import ro.ubbcluj.travelit.serviceapi.model.City;

import java.util.stream.Collectors;


public class CityMapper {

    public static CityDto mapToDto(final City city) {
        return new CityDto()
                .setId(city.getId())
                .setName(city.getName())
                .setDescription(city.getDescription())
                .setCountryName(city.getCountry().getName())
                .setRecommendations(city.getRecommendations()
                        .stream()
                        .map(RecommendationMapper::mapToDto)
                        .collect(Collectors.toSet()));
    }

}
