package ro.ubbcluj.travelit.serviceapi.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import ro.ubbcluj.travelit.serviceapi.controller.dto.CountryDto;
import ro.ubbcluj.travelit.serviceapi.controller.mapper.CountryMapper;
import ro.ubbcluj.travelit.serviceapi.model.Country;
import ro.ubbcluj.travelit.serviceapi.service.CountryService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/countries")
@CrossOrigin(origins = {"*"})
public class CountryController {

    public final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/{id}")
    public CountryDto getById(@PathVariable Long id) {
        return CountryMapper.mapToDto(countryService.getById(id));
    }

    @GetMapping("/populateDatabase")
    public String populateDatabase() {
        return countryService.populateDatabase();
    }

    @GetMapping
    public List<CountryDto> getAll() {
        return countryService.getAll()
                .stream()
                .map(CountryMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping(params = {"page", "size", "sort"})
    public Page<CountryDto> findPaginated(Pageable pageable) {
        return countryService.getPaginated(pageable)
                .map(CountryMapper::mapToDto);
    }

}
