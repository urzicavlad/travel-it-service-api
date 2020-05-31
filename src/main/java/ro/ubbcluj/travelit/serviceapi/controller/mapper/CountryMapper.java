package ro.ubbcluj.travelit.serviceapi.controller.mapper;

import ro.ubbcluj.travelit.serviceapi.controller.dto.CountryDto;
import ro.ubbcluj.travelit.serviceapi.model.Country;

public class CountryMapper {

    public static CountryDto mapToDto(final Country country) {
        return new CountryDto()
                .setId(country.getId())
                .setName(country.getName())
                .setCode(country.getCode())
                .setFlag(country.getFlag())
                .setImage(country.getImage())
                .setDescription(country.getDescription());
    }

    public static Country mapToEntity(final CountryDto countryDto) {
        return new Country()
                .setId(countryDto.getId())
                .setName(countryDto.getName())
                .setCode(countryDto.getCode())
                .setFlag(countryDto.getFlag())
                .setImage(countryDto.getImage())
                .setDescription(countryDto.getDescription());
    }

}
