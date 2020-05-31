package ro.ubbcluj.travelit.serviceapi.service.impl;

import org.springframework.stereotype.Service;
import ro.ubbcluj.travelit.serviceapi.model.City;
import ro.ubbcluj.travelit.serviceapi.repository.CityRepository;
import ro.ubbcluj.travelit.serviceapi.service.CityService;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public List<City> getAll() {
        return new ArrayList<>(cityRepository.findAll());
    }

    @Override
    public City getById(Long id) {
        return null;
    }

    @Override
    public City getByName(String cityName) {
        return cityRepository.findByName(cityName).orElseThrow(()-> new IllegalArgumentException("City not found!"));
    }

    @Override
    public List<City> getByCountryName(String country) {
        return cityRepository.findAllByCountry_Name(country);
    }


}
