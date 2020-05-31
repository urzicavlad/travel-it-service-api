package ro.ubbcluj.travelit.serviceapi.controller;

import org.springframework.web.bind.annotation.*;
import ro.ubbcluj.travelit.serviceapi.controller.dto.CityDto;
import ro.ubbcluj.travelit.serviceapi.controller.dto.RecommendationDto;
import ro.ubbcluj.travelit.serviceapi.controller.mapper.CityMapper;
import ro.ubbcluj.travelit.serviceapi.controller.mapper.RecommendationMapper;
import ro.ubbcluj.travelit.serviceapi.model.Country;
import ro.ubbcluj.travelit.serviceapi.model.Recommendation;
import ro.ubbcluj.travelit.serviceapi.service.CityService;
import ro.ubbcluj.travelit.serviceapi.service.RecommendationService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/recommendations")
public class RecommendationController {

    public final RecommendationService recService;

    public RecommendationController(RecommendationService recService) {
        this.recService = recService;
    }

    @GetMapping("/{id}")
    public Recommendation getById(@PathVariable Long id) {
        return recService.getById(id);
    }

    @GetMapping
    public List<RecommendationDto> getAll() {
        return recService.getAll()
                .stream()
                .map(RecommendationMapper::mapToDto)
                .collect(Collectors.toList());
    }
    @DeleteMapping("/{id}")
    public void deleteById (@PathVariable Long id) {
        recService.deleteById(id);
    }
}
