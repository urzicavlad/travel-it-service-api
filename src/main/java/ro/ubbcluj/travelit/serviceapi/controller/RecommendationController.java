package ro.ubbcluj.travelit.serviceapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.ubbcluj.travelit.serviceapi.controller.dto.RecommendationDto;
import ro.ubbcluj.travelit.serviceapi.controller.mapper.RecommendationMapper;
import ro.ubbcluj.travelit.serviceapi.service.RecommendationService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/recommendations")
@CrossOrigin(origins = {"*"})
public class RecommendationController {

    public RecommendationService recommendationService;

    public RecommendationController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @GetMapping("/filter")
    public List<RecommendationDto> getByRecommendationsByCity(@RequestParam String city) {
        return recommendationService.getByRecommendationsByCityName(city)
                .stream()
                .map(RecommendationMapper::mapToDto)
                .collect(Collectors.toList());
    }

}
