package ro.ubbcluj.travelit.serviceapi.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ro.ubbcluj.travelit.serviceapi.model.City;
import ro.ubbcluj.travelit.serviceapi.model.Country;
import ro.ubbcluj.travelit.serviceapi.repository.CityRepository;
import ro.ubbcluj.travelit.serviceapi.service.CityService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public List<City> getAll() {
        return StreamSupport.stream(cityRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public City getById(Long id) {
        return null;
    }

    @Override
    public List<City> getByCountry(String country) {
        return cityRepository.findAllByCountry_Name(country);
    }


}
