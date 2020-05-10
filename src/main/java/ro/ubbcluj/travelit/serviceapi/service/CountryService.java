package ro.ubbcluj.travelit.serviceapi.service;

import ro.ubbcluj.travelit.serviceapi.model.Country;

import java.util.List;

public interface CountryService {

    List<Country> getAllCountries();

    Country getCountryById(Long id);

    String populateDatabase();
}
