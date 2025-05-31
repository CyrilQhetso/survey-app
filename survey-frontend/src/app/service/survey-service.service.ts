import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Survey, SurveyResults } from '../models/survey.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SurveyServiceService {

  private apiUrl = 'http://localhost:8080/api/surveys';

  constructor(private http: HttpClient) { }

  submitSurvey(survey: Survey): Observable<Survey> {
    return this.http.post<Survey>(this.apiUrl, survey);
  }

  getSurveyResults(): Observable<SurveyResults> {
    return this.http.get<SurveyResults>(`${this.apiUrl}/results`);
  }
}
