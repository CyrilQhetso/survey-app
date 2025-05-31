package com.survey.survey_backend.service;

import com.survey.survey_backend.dto.SurveyResultsDto;
import com.survey.survey_backend.model.Survey;
import com.survey.survey_backend.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.Period;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class SurveyService {

    @Autowired
    private SurveyRepository surveyRepository;

    public Survey saveSurvey(Survey survey) {
        // Validate age based on date of birth
        int age = Period.between(survey.getDateOfBirth(), LocalDate.now()).getYears();
        if (age < 5 || age > 120) {
            throw new IllegalArgumentException("Age must be between 5 and 120 years");
        }
        return surveyRepository.save(survey);
    }

    public SurveyResultsDto getSurveyResults() {
        long totalSurveys = surveyRepository.count();
        
        if (totalSurveys == 0) {
            return null;
        }

        SurveyResultsDto results = new SurveyResultsDto();
        results.setTotalSurveys(totalSurveys);
        
        // Age statistics
        Double avgAge = surveyRepository.findAverageAge();
        results.setAverageAge(avgAge != null ? round(avgAge, 1) : 0.0);
        results.setOldestAge(surveyRepository.findMaxAge());
        results.setYoungestAge(surveyRepository.findMinAge());
        
        // Food preferences percentages
        Long pizzaCount = surveyRepository.countSurveysWithPizza();
        Long pastaCount = surveyRepository.countSurveysWithPasta();
        Long papAndWorsCount = surveyRepository.countSurveysWithPapAndWors();
        
        results.setPizzaPercentage(round((pizzaCount * 100.0) / totalSurveys, 1));
        results.setPastaPercentage(round((pastaCount * 100.0) / totalSurveys, 1));
        results.setPapAndWorsPercentage(round((papAndWorsCount * 100.0) / totalSurveys, 1));
        
        // Activity ratings averages - these represent average agreement levels
        Double watchMoviesAvg = surveyRepository.findAverageWatchMoviesRating();
        Double listenRadioAvg = surveyRepository.findAverageListenRadioRating();
        Double eatOutAvg = surveyRepository.findAverageEatOutRating();
        Double watchTvAvg = surveyRepository.findAverageWatchTvRating();
        
        results.setWatchMoviesAverage(watchMoviesAvg != null ? round(watchMoviesAvg, 1) : 0.0);
        results.setListenRadioAverage(listenRadioAvg != null ? round(listenRadioAvg, 1) : 0.0);
        results.setEatOutAverage(eatOutAvg != null ? round(eatOutAvg, 1) : 0.0);
        results.setWatchTvAverage(watchTvAvg != null ? round(watchTvAvg, 1) : 0.0);
        
        return results;
    }
    
    private double round(double value, int places) {
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
