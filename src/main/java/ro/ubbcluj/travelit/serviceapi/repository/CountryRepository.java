package ro.ubbcluj.travelit.serviceapi.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ro.ubbcluj.travelit.serviceapi.model.Country;

@Repository
public interface CountryRepository extends PagingAndSortingRepository<Country, Long> {
}
