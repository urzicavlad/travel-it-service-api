package ro.ubbcluj.travelit.serviceapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.ubbcluj.travelit.serviceapi.model.Country;
import ro.ubbcluj.travelit.serviceapi.service.CountryService;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {

    public final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public List<Country> getAll() {
        return countryService.getAllCountries();
    }

    @GetMapping("/{id}")
    public Country getById(@PathVariable Long id) {
        return countryService.getCountryById(id);
    }

    @GetMapping("/populateDatabase")
    public String populateDatabase() {
        return countryService.populateDatabase();
    }
}
