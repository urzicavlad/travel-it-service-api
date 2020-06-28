package ro.ubbcluj.travelit.serviceapi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ro.ubbcluj.travelit.serviceapi.model.Country;

import java.util.List;

public interface CountryService {

    List<Country> getAll();

    Country getById(Long id);

    String populateDatabase();

    Page<Country> getPaginated(Pageable pageable);

    Country getByName(String name);

    Country save(Country country);
}
