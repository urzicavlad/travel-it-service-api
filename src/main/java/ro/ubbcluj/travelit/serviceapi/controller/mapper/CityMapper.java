package ro.ubbcluj.travelit.serviceapi.controller.mapper;

import ro.ubbcluj.travelit.serviceapi.controller.dto.CityDto;
import ro.ubbcluj.travelit.serviceapi.controller.dto.RecommendationDto;
import ro.ubbcluj.travelit.serviceapi.model.City;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


public class CityMapper {

    public static CityDto mapToDto(final City city) {
        CityDto cityDto = new CityDto()
                .setId(city.getId())
                .setName(city.getName())
                .setDescription(city.getDescription())
                .setCountryName(city.getCountry().getName())
                .setRecommendations(new HashSet<>());
        if (city.getRecommendations() != null){
            Set<RecommendationDto> recommendationDtos = city.getRecommendations()
                    .stream()
                    .map(RecommendationMapper::mapToDto)
                    .collect(Collectors.toSet());
            cityDto.setRecommendations(recommendationDtos);
        }
        return cityDto;
    }

    public static City mapToEntity(final CityDto cityDto) {
        return new City()
                .setId(cityDto.getId())
                .setName(cityDto.getName())
                .setDescription(cityDto.getDescription());
    }

}
