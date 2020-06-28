package ro.ubbcluj.travelit.serviceapi.controller;

import org.springframework.web.bind.annotation.*;
import ro.ubbcluj.travelit.serviceapi.controller.dto.CityDto;
import ro.ubbcluj.travelit.serviceapi.controller.mapper.CityMapper;
import ro.ubbcluj.travelit.serviceapi.model.City;
import ro.ubbcluj.travelit.serviceapi.model.Country;
import ro.ubbcluj.travelit.serviceapi.service.CityService;
import ro.ubbcluj.travelit.serviceapi.service.CountryService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cities")
@CrossOrigin(origins = {"*"})
public class CityController {

    public final CityService cityService;
    public final CountryService countryService;

    public CityController(CityService cityService, CountryService countryService) {
        this.cityService = cityService;
        this.countryService = countryService;
    }

    @GetMapping("/{id}")
    public City getById(@PathVariable Long id) {
        return cityService.getById(id);
    }

    @GetMapping("/filter")
    public List<CityDto> getCitiesByCountryName(@RequestParam String country) {
        return cityService.getByCountryName(country)
                .stream()
                .map(CityMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping
    public List<CityDto> getAll() {
        return cityService.getAll()
                .stream()
                .map(CityMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public CityDto save(@RequestBody CityDto cityDto) {
        City city = CityMapper.mapToEntity(cityDto);
        Country country = countryService.getByName(cityDto.getCountryName());
        city.setCountry(country);
        City savedCity = cityService.save(city);
        return CityMapper.mapToDto(savedCity);
    }


}
