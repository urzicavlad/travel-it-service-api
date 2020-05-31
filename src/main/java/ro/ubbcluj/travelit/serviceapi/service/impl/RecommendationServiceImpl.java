package ro.ubbcluj.travelit.serviceapi.service.impl;

import org.springframework.stereotype.Service;
import ro.ubbcluj.travelit.serviceapi.model.Recommendation;
import ro.ubbcluj.travelit.serviceapi.repository.RecommendationRepository;
import ro.ubbcluj.travelit.serviceapi.service.RecommendationService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class RecommendationServiceImpl implements RecommendationService {

    private final RecommendationRepository recommendationRepository;

    public RecommendationServiceImpl(RecommendationRepository recommendationRepository) {
        this.recommendationRepository = recommendationRepository;
    }


    @Override
    public List<Recommendation> getAll() {
        /*return new ArrayList<>(recommendationRepository.findAll());*/
        List<Recommendation> recommendations = recommendationRepository.findAll();
        return StreamSupport.stream(recommendations.spliterator(),false).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        /*List<Recommendation> recommendations = recommendationRepository.findAll();
        recommendations.removeIf(recommendation -> recommendation.getId().equals(id));*/
        recommendationRepository.deleteById(id);
    }

    @Override
    public Recommendation getById(Long id) {
        return recommendationRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Recommendation not found!"));
    }
    private final RecommendationRepository recommendationRepository;

    public RecommendationServiceImpl(RecommendationRepository recommendationRepository) {
        this.recommendationRepository = recommendationRepository;
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
