package ro.ubbcluj.travelit.serviceapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ro.ubbcluj.travelit.serviceapi.model.Country;

@Repository
public interface CountryRepository extends CrudRepository<Country, Long> {

}
