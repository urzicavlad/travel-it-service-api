package ro.ubbcluj.travelit.serviceapi.service;

import ro.ubbcluj.travelit.serviceapi.model.Recommendation;

import java.util.List;

public interface RecommendationService {

    List<Recommendation> getAll();

    void deleteById(Long id);

    Recommendation getById(Long id);

    Recommendation save(Recommendation recommendation);
}
