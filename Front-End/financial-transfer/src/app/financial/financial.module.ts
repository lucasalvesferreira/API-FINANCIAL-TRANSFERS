import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';

import { AppMaterialModule } from '../shared/app-material/app-material.module';
import { SharedModule } from './../shared/shared.module';
import { FinancialRoutingModule } from './financial-routing.module';
import { FinancialComponent } from './financial/financial.component';
import { SchedulesFormComponent } from './schedules-form/schedules-form.component';




@NgModule({
  declarations: [
    FinancialComponent,
    SchedulesFormComponent
  ],
  imports: [
    CommonModule,
    FinancialRoutingModule,
    AppMaterialModule,
    SharedModule,
    ReactiveFormsModule

  ]
})
export class FinancialModule { }
