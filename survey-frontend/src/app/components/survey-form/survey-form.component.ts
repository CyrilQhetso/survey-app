import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { SurveyServiceService } from '../../service/survey-service.service';
import { Survey } from '../../models/survey.model';

@Component({
  selector: 'app-survey-form',
  standalone: false,
  templateUrl: './survey-form.component.html',
  styleUrl: './survey-form.component.css'
})
export class SurveyFormComponent {
  surveyForm: FormGroup;
  submitted = false;
  submitSuccess = false;
  submitError = false;

  foodOptions = ['Pizza', 'Pasta', 'Pap and Wors', 'Other'];
  ratingOptions = [
    { value: 1, label: 'Strongly Agree' },
    { value: 2, label: 'Agree' },
    { value: 3, label: 'Neutral' },
    { value: 4, label: 'Disagree' },
    { value: 5, label: 'Strongly Disagree' }
  ];

  constructor(
    private fb: FormBuilder,
    private surveyService: SurveyServiceService
  ) {
    this.surveyForm = this.fb.group({
      fullName: ['', [Validators.required]],
      email: ['', [Validators.required, Validators.email]],
      dateOfBirth: ['', [Validators.required]],
      contactNumber: ['', [Validators.required]],
      favoriteFoods: this.fb.array([], [Validators.required]),
      watchMoviesRating: ['', [Validators.required]],
      listenRadioRating: ['', [Validators.required]],
      eatOutRating: ['', [Validators.required]],
      watchTvRating: ['', [Validators.required]]
    });
  }

  get favoriteFoodsArray() {
    return this.surveyForm.get('favoriteFoods') as FormArray;
  }

  onFoodChange(event: any, food: string) {
    if (event.target.checked) {
      this.favoriteFoodsArray.push(this.fb.control(food));
    } else {
      const index = this.favoriteFoodsArray.controls.findIndex(x => x.value === food);
      this.favoriteFoodsArray.removeAt(index);
    }
  }

  isFoodSelected(food: string): boolean {
    return this.favoriteFoodsArray.value.includes(food);
  }

  calculateAge(): number {
    const dob = new Date(this.surveyForm.get('dateOfBirth')?.value);
    const today = new Date();
    let age = today.getFullYear() - dob.getFullYear();
    const monthDiff = today.getMonth() - dob.getMonth();
    if (monthDiff < 0 || (monthDiff === 0 && today.getDate() < dob.getDate())) {
      age--;
    }
    return age;
  }

  onSubmit() {
    this.submitted = true;
    this.submitSuccess = false;
    this.submitError = false;

    if (this.surveyForm.valid) {
      // Validate age
      const age = this.calculateAge();
      if (age < 5 || age > 120) {
        alert('Age must be between 5 and 120 years');
        return;
      }

      const survey: Survey = {
        fullName: this.surveyForm.get('fullName')?.value,
        email: this.surveyForm.get('email')?.value,
        dateOfBirth: this.surveyForm.get('dateOfBirth')?.value,
        contactNumber: this.surveyForm.get('contactNumber')?.value,
        favoriteFoods: this.favoriteFoodsArray.value,
        watchMoviesRating: parseInt(this.surveyForm.get('watchMoviesRating')?.value),
        listenRadioRating: parseInt(this.surveyForm.get('listenRadioRating')?.value),
        eatOutRating: parseInt(this.surveyForm.get('eatOutRating')?.value),
        watchTvRating: parseInt(this.surveyForm.get('watchTvRating')?.value)
      };

      this.surveyService.submitSurvey(survey).subscribe({
        next: (response) => {
          this.submitSuccess = true;
          this.surveyForm.reset();
          this.favoriteFoodsArray.clear();
          this.submitted = false;
        },
        error: (error) => {
          this.submitError = true;
        }
      });
    }
  }

  isFieldInvalid(fieldName: string): boolean {
    const field = this.surveyForm.get(fieldName);
    return !!(field && field.invalid && (field.dirty || field.touched || this.submitted));
  }
}
