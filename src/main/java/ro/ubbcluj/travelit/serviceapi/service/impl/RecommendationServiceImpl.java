package ro.ubbcluj.travelit.serviceapi.service.impl;

import org.springframework.stereotype.Service;
import ro.ubbcluj.travelit.serviceapi.model.Recommendation;
import ro.ubbcluj.travelit.serviceapi.repository.RecommendationRepository;
import ro.ubbcluj.travelit.serviceapi.service.CityService;
import ro.ubbcluj.travelit.serviceapi.service.RecommendationService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
    public class RecommendationServiceImpl implements RecommendationService {

    private final CityService cityService;
    private final RecommendationRepository recommendationRepository;

    public RecommendationServiceImpl(CityService cityService, RecommendationRepository recommendationRepository) {
        this.recommendationRepository = recommendationRepository;
        this.cityService = cityService;
    }

    @Override
    public List<Recommendation> getAll() {
        return new ArrayList<>(recommendationRepository.findAll());
    }

    @Override
    public void deleteById(Long id) {
        recommendationRepository.deleteById(id);
    }

    @Override
    public Recommendation getById(Long id) {
        return recommendationRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Recommendation not found!"));
    }

    @Override
    public Set<Recommendation> getByRecommendationsByCityName(String cityName) {
        return cityService.getByName(cityName).getRecommendations();
    }

    @Override
    public Recommendation save(Recommendation recommendation) {
        if (recommendationRepository.findByName(recommendation.getName()).isPresent())
            throw new IllegalArgumentException("Name taken!");

        if (recommendationRepository.findByAddress(recommendation.getAddress()).isPresent())
            throw new IllegalArgumentException("Address already registered!");

        if (recommendationRepository.findByDescription(recommendation.getDescription()).isPresent())
            throw new IllegalArgumentException("Description already in use!");

        return recommendationRepository.save(recommendation);
    }
}

