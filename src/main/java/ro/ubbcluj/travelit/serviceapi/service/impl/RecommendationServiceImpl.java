package ro.ubbcluj.travelit.serviceapi.service.impl;

import org.springframework.stereotype.Service;
import ro.ubbcluj.travelit.serviceapi.model.Recommendation;
import ro.ubbcluj.travelit.serviceapi.repository.CityRepository;
import ro.ubbcluj.travelit.serviceapi.repository.RecommendationRepository;
import ro.ubbcluj.travelit.serviceapi.service.CityService;
import ro.ubbcluj.travelit.serviceapi.service.RecommendationService;

import java.util.List;
import java.util.Set;

@Service
public class RecommendationServiceImpl implements RecommendationService {

    private final CityService cityService;

    public RecommendationServiceImpl(CityService cityService) {
        this.cityService = cityService;
    }

    @Override
    public Set<Recommendation> getByRecommendationsByCityName(String cityName) {
        return cityService.getByName(cityName).getRecommendations();
    }
}
