package ro.ubbcluj.travelit.serviceapi.service;

import ro.ubbcluj.travelit.serviceapi.model.Recommendation;

import java.util.Set;

public interface RecommendationService {

    Recommendation save(Recommendation recommendation);

    Set<Recommendation> getByRecommendationsByCityName(String cityName);
}
