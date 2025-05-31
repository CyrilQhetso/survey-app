import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SurveyFormComponent } from './components/survey-form/survey-form.component';
import { SurveyResultsComponent } from './components/survey-results/survey-results.component';

const routes: Routes = [
  { path: '', redirectTo: '/survey', pathMatch: 'full' },
  { path: 'survey', component: SurveyFormComponent },
  { path: 'results', component: SurveyResultsComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
