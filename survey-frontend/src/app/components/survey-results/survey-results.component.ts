import { Component, OnInit } from '@angular/core';
import { SurveyResults } from '../../models/survey.model';
import { SurveyServiceService } from '../../service/survey-service.service';

@Component({
  selector: 'app-survey-results',
  standalone: false,
  templateUrl: './survey-results.component.html',
  styleUrl: './survey-results.component.css'
})
export class SurveyResultsComponent implements OnInit {
  surveyResults: SurveyResults | null = null;
  loading = true;
  noData = false;

  constructor(private surveyService: SurveyServiceService) {}

  ngOnInit(): void {
    this.loadSurveyResults();
  }

  loadSurveyResults(): void {
    this.surveyService.getSurveyResults().subscribe({
      next: (results) => {
          this.surveyResults = results;
          this.loading = false;
          if (!results) {
              this.noData = true;
          }
      },
      error: (error) => {
          if (error.status === 204 || !error.error) {
              this.noData = true;
          }
          this.loading = false;
      }
    });
  }

  // Helper methods to safely access properties
  get totalSurveys(): number {
    return this.surveyResults?.totalSurveys ?? 0;
  }

  get averageAge(): number {
    return this.surveyResults?.averageAge ?? 0;
  }

  get oldestAge(): number {
    return this.surveyResults?.oldestAge ?? 0;
  }

  get youngestAge(): number {
    return this.surveyResults?.youngestAge ?? 0;
  }

  get pizzaPercentage(): number {
    return this.surveyResults?.pizzaPercentage ?? 0;
  }

  get pastaPercentage(): number {
    return this.surveyResults?.pastaPercentage ?? 0;
  }

  get papAndWorsPercentage(): number {
    return this.surveyResults?.papAndWorsPercentage ?? 0;
  }

  get watchMoviesAverage(): number {
    return this.surveyResults?.watchMoviesAverage ?? 0;
  }

  get listenRadioAverage(): number {
    return this.surveyResults?.listenRadioAverage ?? 0;
  }

  get eatOutAverage(): number {
    return this.surveyResults?.eatOutAverage ?? 0;
  }

  get watchTvAverage(): number {
    return this.surveyResults?.watchTvAverage ?? 0;
  }
}
