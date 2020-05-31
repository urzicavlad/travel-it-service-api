package ro.ubbcluj.travelit.serviceapi.service.impl;

import org.springframework.stereotype.Service;
import ro.ubbcluj.travelit.serviceapi.model.Recommendation;
import ro.ubbcluj.travelit.serviceapi.model.User;
import ro.ubbcluj.travelit.serviceapi.repository.RecommendationRepository;
import ro.ubbcluj.travelit.serviceapi.repository.UserRepository;
import ro.ubbcluj.travelit.serviceapi.service.RecommendationService;

 import javax.mail.internet.AddressException;
 import javax.mail.internet.InternetAddress;

@Service
    public class RecommendationServiceImpl implements RecommendationService {

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

