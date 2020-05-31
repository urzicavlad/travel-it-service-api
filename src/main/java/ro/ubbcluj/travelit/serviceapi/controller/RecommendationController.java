package ro.ubbcluj.travelit.serviceapi.controller;

import org.springframework.web.bind.annotation.*;
import ro.ubbcluj.travelit.serviceapi.controller.dto.RecommendationDto;
import ro.ubbcluj.travelit.serviceapi.controller.mapper.RecommendationMapper;
import ro.ubbcluj.travelit.serviceapi.model.Recommendation;
import ro.ubbcluj.travelit.serviceapi.service.RecommendationService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/recommendations")
@CrossOrigin(origins = {"*"})
public class RecommendationController {

    private RecommendationService recommendationService;

    public RecommendationController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @GetMapping("/{id}")
    public Recommendation getById(@PathVariable Long id) {
        return recommendationService.getById(id);
    }

    @PostMapping
    public RecommendationDto add(@Valid @RequestBody RecommendationDto recommendationDto) {
        return RecommendationMapper.mapToDto(recommendationService.save(RecommendationMapper.mapToEntity(recommendationDto)));
    }

    @GetMapping("/filter")
    public List<RecommendationDto> getByRecommendationsByCity(@RequestParam String city) {
        return recommendationService.getByRecommendationsByCityName(city)
                .stream()
                .map(RecommendationMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping
    public List<RecommendationDto> getAll() {
        return recommendationService.getAll()
                .stream()
                .map(RecommendationMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        recommendationService.deleteById(id);
    }
}
