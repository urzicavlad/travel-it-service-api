package ro.ubbcluj.travelit.serviceapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.ubbcluj.travelit.serviceapi.model.Recommendation;
import ro.ubbcluj.travelit.serviceapi.model.User;

import java.util.Optional;

@Repository
public interface RecommendationRepository extends JpaRepository<Recommendation, Long> {

    Optional<Recommendation> findByName(String name);

    Optional<Recommendation> findByAddress(String address);

    Optional<Recommendation> findByDescription(String description);

}
