package com.survey.survey_backend.dto;

public class SurveyResultsDto {

    private Long totalSurveys;
    private Double averageAge;
    private Integer oldestAge;
    private Integer youngestAge;
    private Double pizzaPercentage;
    private Double pastaPercentage;
    private Double papAndWorsPercentage;
    private Double watchMoviesAverage;
    private Double listenRadioAverage;
    private Double eatOutAverage;
    private Double watchTvAverage;

    // Constructors
    public SurveyResultsDto() {}

    // Getters and Setters
    public Long getTotalSurveys() { 
        return totalSurveys; 
    }
    public void setTotalSurveys(Long totalSurveys) { 
        this.totalSurveys = totalSurveys; 
    }

    public Double getAverageAge() { 
        return averageAge; 
    }
    public void setAverageAge(Double averageAge) { 
        this.averageAge = averageAge; 
    }

    public Integer getOldestAge() { 
        return oldestAge; 
    }
    public void setOldestAge(Integer oldestAge) { 
        this.oldestAge = oldestAge; 
    }

    public Integer getYoungestAge() { 
        return youngestAge; 
    }
    public void setYoungestAge(Integer youngestAge) { 
        this.youngestAge = youngestAge; 
    }

    public Double getPizzaPercentage() { 
        return pizzaPercentage; 
    }
    public void setPizzaPercentage(Double pizzaPercentage) { 
        this.pizzaPercentage = pizzaPercentage; 
    }

    public Double getPastaPercentage() { 
        return pastaPercentage; 
    }
    public void setPastaPercentage(Double pastaPercentage) { 
        this.pastaPercentage = pastaPercentage; 
    }

    public Double getPapAndWorsPercentage() { 
        return papAndWorsPercentage; 
    }
    public void setPapAndWorsPercentage(Double papAndWorsPercentage) { 
        this.papAndWorsPercentage = papAndWorsPercentage; 
    }

    public Double getWatchMoviesAverage() { 
        return watchMoviesAverage; 
    }
    public void setWatchMoviesAverage(Double watchMoviesAverage) { 
        this.watchMoviesAverage = watchMoviesAverage; 
    }

    public Double getListenRadioAverage() { 
        return listenRadioAverage; 
    }
    public void setListenRadioAverage(Double listenRadioAverage) { 
        this.listenRadioAverage = listenRadioAverage; 
    }

    public Double getEatOutAverage() { 
        return eatOutAverage; 
    }
    public void setEatOutAverage(Double eatOutAverage) { 
        this.eatOutAverage = eatOutAverage; 
    }

    public Double getWatchTvAverage() { 
        return watchTvAverage; 
    }
    public void setWatchTvAverage(Double watchTvAverage) { 
        this.watchTvAverage = watchTvAverage; 
    }
}
