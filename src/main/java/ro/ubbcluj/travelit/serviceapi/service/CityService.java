package ro.ubbcluj.travelit.serviceapi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ro.ubbcluj.travelit.serviceapi.model.City;
import ro.ubbcluj.travelit.serviceapi.model.Country;


import java.util.List;

public interface CityService {

    List<City> getAll();

    City getById(Long id);

    List<City> getByCountry(String country);

}
