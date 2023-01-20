import { Financial } from './../model/financial';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-financial',
  templateUrl: './financial.component.html',
  styleUrls: ['./financial.component.scss']
})
export class FinancialComponent implements OnInit {

financial: Financial[] = [
  {
    _id: 4,
    sourceAccount: '123123',
    targetAccount: '654321',
    transferValue: '500.0',
    rate: '23.5',
    transferDate: '2023-02-20',
    appointmentDate: '2023-01-20'
}
];
displayedColumns = ['sourceAccount','targetAccount','transferValue','rate','transferDate','appointmentDate'];

constructor(){

}

ngOnInit(): void {

}

}
