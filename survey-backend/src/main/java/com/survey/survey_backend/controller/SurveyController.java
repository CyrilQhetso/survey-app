package com.survey.survey_backend.controller;

import com.survey.survey_backend.dto.SurveyResultsDto;
import com.survey.survey_backend.model.Survey;
import com.survey.survey_backend.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/surveys")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials = "true")
public class SurveyController {

    @Autowired
    private SurveyService surveyService;

    @PostMapping
    public ResponseEntity<?> submitSurvey(@Valid @RequestBody Survey survey, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body("Validation errors occurred");
        }
        
        try {
            Survey savedSurvey = surveyService.saveSurvey(survey);
            return ResponseEntity.ok(savedSurvey);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("An error occurred while saving the survey");
        }
    }

    @GetMapping("/results")
    public ResponseEntity<SurveyResultsDto> getSurveyResults() {
        try {
            SurveyResultsDto results = surveyService.getSurveyResults();
            if (results == null) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(results);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}