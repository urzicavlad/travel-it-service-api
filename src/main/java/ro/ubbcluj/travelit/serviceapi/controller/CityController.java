package ro.ubbcluj.travelit.serviceapi.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import ro.ubbcluj.travelit.serviceapi.controller.dto.CityDto;
import ro.ubbcluj.travelit.serviceapi.controller.dto.CountryDto;
import ro.ubbcluj.travelit.serviceapi.controller.dto.RecommendationDto;
import ro.ubbcluj.travelit.serviceapi.controller.mapper.CityMapper;
import ro.ubbcluj.travelit.serviceapi.controller.mapper.CountryMapper;
import ro.ubbcluj.travelit.serviceapi.controller.mapper.RecommendationMapper;
import ro.ubbcluj.travelit.serviceapi.model.City;
import ro.ubbcluj.travelit.serviceapi.model.Country;
import ro.ubbcluj.travelit.serviceapi.model.Recommendation;
import ro.ubbcluj.travelit.serviceapi.service.CityService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cities")
public class CityController {
    public final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/{id}")
    public City getById(@PathVariable Long id) {
        return cityService.getById(id);
    }

    //("/cities?country=Romania")
    @GetMapping("/filter")

    public List<CityDto> getByCountry(@RequestParam String country){
       return cityService.getByCountry(country).stream().map(CityMapper::mapToDto).collect(Collectors.toList());
    }

    @GetMapping
    public List<CityDto> getAll() {
        return cityService.getAll()
                .stream()
                .map(CityMapper::mapToDto)
                .collect(Collectors.toList());
    }


}
