package ro.ubbcluj.travelit.serviceapi.service;

import ro.ubbcluj.travelit.serviceapi.model.City;

import java.util.List;

public interface CityService {

    List<City> getAll();

    City getById(Long id);

    City getByName(String cityName);

    List<City> getByCountryName(String country);

}
