package ro.ubbcluj.travelit.serviceapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.ubbcluj.travelit.serviceapi.model.City;

import java.util.List;
import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    List<City> findAllByCountry_Name(String country);

    Optional<City> findByName(String cityName);

}
