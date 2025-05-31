package com.survey.survey_backend.repository;

import com.survey.survey_backend.model.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, Long> {

    @Query("SELECT AVG(YEAR(CURRENT_DATE) - YEAR(s.dateOfBirth)) FROM Survey s")
    Double findAverageAge();
    
    @Query("SELECT MAX(YEAR(CURRENT_DATE) - YEAR(s.dateOfBirth)) FROM Survey s")
    Integer findMaxAge();
    
    @Query("SELECT MIN(YEAR(CURRENT_DATE) - YEAR(s.dateOfBirth)) FROM Survey s")
    Integer findMinAge();
    
    @Query("SELECT COUNT(s) FROM Survey s JOIN s.favoriteFoods f WHERE f = 'Pizza'")
    Long countSurveysWithPizza();
    
    @Query("SELECT COUNT(s) FROM Survey s JOIN s.favoriteFoods f WHERE f = 'Pasta'")
    Long countSurveysWithPasta();
    
    @Query("SELECT COUNT(s) FROM Survey s JOIN s.favoriteFoods f WHERE f = 'Pap and Wors'")
    Long countSurveysWithPapAndWors();
    
    @Query("SELECT AVG(s.watchMoviesRating) FROM Survey s")
    Double findAverageWatchMoviesRating();
    
    @Query("SELECT AVG(s.listenRadioRating) FROM Survey s")
    Double findAverageListenRadioRating();
    
    @Query("SELECT AVG(s.eatOutRating) FROM Survey s")
    Double findAverageEatOutRating();
    
    @Query("SELECT AVG(s.watchTvRating) FROM Survey s")
    Double findAverageWatchTvRating();
}
