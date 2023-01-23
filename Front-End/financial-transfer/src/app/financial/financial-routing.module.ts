import { SchedulesFormComponent } from './schedules-form/schedules-form.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { FinancialComponent } from './financial/financial.component';

const routes: Routes = [
  {path: '',component: FinancialComponent},
  {path: 'new',component: SchedulesFormComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class FinancialRoutingModule { }
