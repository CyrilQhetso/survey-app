package com.survey.survey_backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "surveys")
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Full name is required")
    @Column(name = "full_name")
    private String fullName;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    @NotNull(message = "Date of birth is required")
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @NotBlank(message = "Contact number is required")
    @Column(name = "contact_number")
    private String contactNumber;

    @ElementCollection
    @CollectionTable(name = "survey_favorite_foods", joinColumns = @JoinColumn(name = "survey_id"))
    @Column(name = "food")
    private List<String> favoriteFoods;

    @Min(value = 1, message = "Rating must be between 1 and 5")
    @Max(value = 5, message = "Rating must be between 1 and 5")
    @Column(name = "watch_movies_rating")
    private Integer watchMoviesRating;

    @Min(value = 1, message = "Rating must be between 1 and 5")
    @Max(value = 5, message = "Rating must be between 1 and 5")
    @Column(name = "listen_radio_rating")
    private Integer listenRadioRating;

    @Min(value = 1, message = "Rating must be between 1 and 5")
    @Max(value = 5, message = "Rating must be between 1 and 5")
    @Column(name = "eat_out_rating")
    private Integer eatOutRating;

    @Min(value = 1, message = "Rating must be between 1 and 5")
    @Max(value = 5, message = "Rating must be between 1 and 5")
    @Column(name = "watch_tv_rating")
    private Integer watchTvRating;

    // Constructors
    public Survey() {}

    // Getters and Setters
    public Long getId() { 
        return id; 
    }
    public void setId(Long id) { 
        this.id = id; 
    }

    public String getFullName() { 
        return fullName; 
    }
    public void setFullName(String fullName) { 
        this.fullName = fullName; 
    }

    public String getEmail() { 
        return email; 
    }
    public void setEmail(String email) { 
        this.email = email; 
    }

    public LocalDate getDateOfBirth() { 
        return dateOfBirth; 
    }
    public void setDateOfBirth(LocalDate dateOfBirth) { 
        this.dateOfBirth = dateOfBirth; 
    }

    public String getContactNumber() { 
        return contactNumber; 
    }
    public void setContactNumber(String contactNumber) { 
        this.contactNumber = contactNumber; 
    }

    public List<String> getFavoriteFoods() { 
        return favoriteFoods; 
    }
    public void setFavoriteFoods(List<String> favoriteFoods) { 
        this.favoriteFoods = favoriteFoods; 
    }

    public Integer getWatchMoviesRating() { 
        return watchMoviesRating; 
    }
    public void setWatchMoviesRating(Integer watchMoviesRating) { 
        this.watchMoviesRating = watchMoviesRating; 
    }

    public Integer getListenRadioRating() { 
        return listenRadioRating; 
    }
    public void setListenRadioRating(Integer listenRadioRating) { 
        this.listenRadioRating = listenRadioRating; 
    }

    public Integer getEatOutRating() { 
        return eatOutRating; 
    }
    public void setEatOutRating(Integer eatOutRating) { 
        this.eatOutRating = eatOutRating; 
    }

    public Integer getWatchTvRating() { 
        return watchTvRating; 
    }
    public void setWatchTvRating(Integer watchTvRating) { 
        this.watchTvRating = watchTvRating; 
    }
}