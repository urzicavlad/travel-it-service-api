package ro.ubbcluj.travelit.serviceapi.controller.mapper;

import ro.ubbcluj.travelit.serviceapi.controller.dto.CityDto;
import ro.ubbcluj.travelit.serviceapi.controller.dto.RecommendationDto;
import ro.ubbcluj.travelit.serviceapi.model.City;
import ro.ubbcluj.travelit.serviceapi.model.Recommendation;

import java.util.HashSet;
import java.util.Set;


public class CityMapper {

    public static CityDto mapToDto(final City city) {
        Set<RecommendationDto> recommendationDtoSet = new HashSet<>();
        for (Recommendation rec:city.getRecommendations()
             ) {
            recommendationDtoSet.add(RecommendationMapper.mapToDto(rec));

        }
        return new CityDto()
                .setId(city.getId())
                .setName(city.getName())
                .setIdCountry(city.getCountry().getId())
                .setRecommendations(recommendationDtoSet);
    }

//    public static City mapToEntity(final CityDto cityDto) {
//        return new City()
//                .setId(cityDto.getId())
//                .setName(cityDto.getName())
//                .set
//                .setFlag(countryDto.getFlag());
//    }


}
