import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { MatTableModule } from '@angular/material/table';

import { FinancialRoutingModule } from './financial-routing.module';
import { FinancialComponent } from './financial/financial.component';



@NgModule({
  declarations: [
    FinancialComponent
  ],
  imports: [
    CommonModule,
    FinancialRoutingModule,
    MatTableModule
  ]
})
export class FinancialModule { }
