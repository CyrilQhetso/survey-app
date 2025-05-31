export interface Survey {
    id?: number;
    fullName: string;
    email: string;
    dateOfBirth: string;
    contactNumber: string;
    favoriteFoods: string[];
    watchMoviesRating: number;
    listenRadioRating: number;
    eatOutRating: number;
    watchTvRating: number;
}

export interface SurveyResults {
    totalSurveys: number;
    averageAge: number;
    oldestAge: number;
    youngestAge: number;
    pizzaPercentage: number;
    pastaPercentage: number;
    papAndWorsPercentage: number;
    watchMoviesAverage: number;
    listenRadioAverage: number;
    eatOutAverage: number;
    watchTvAverage: number;
}