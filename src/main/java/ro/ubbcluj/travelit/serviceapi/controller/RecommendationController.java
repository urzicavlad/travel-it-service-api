package ro.ubbcluj.travelit.serviceapi.controller;

import org.springframework.web.bind.annotation.*;
import ro.ubbcluj.travelit.serviceapi.controller.dto.RecommendationDto;
import ro.ubbcluj.travelit.serviceapi.controller.dto.UserDto;
import ro.ubbcluj.travelit.serviceapi.controller.mapper.RecommendationMapper;
import ro.ubbcluj.travelit.serviceapi.controller.mapper.UserMapper;
import ro.ubbcluj.travelit.serviceapi.service.RecommendationService;
import ro.ubbcluj.travelit.serviceapi.service.UserService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/recommendations")
public class RecommendationController {

    private RecommendationService recommendationService;

    public RecommendationController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @PostMapping
    public RecommendationDto add(@Valid @RequestBody RecommendationDto recommendationDto) {
        return RecommendationMapper.mapToDto(recommendationService.save(RecommendationMapper.mapToEntity(recommendationDto)));
    }
}
