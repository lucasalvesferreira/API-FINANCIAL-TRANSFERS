import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { catchError, Observable, of } from 'rxjs';
import { ErrorDialogComponent } from 'src/app/shared/components/error-dialog/error-dialog.component';

import { Financial } from './../model/financial';
import { FinancialService } from './../services/financial.service';

@Component({
  selector: 'app-financial',
  templateUrl: './financial.component.html',
  styleUrls: ['./financial.component.scss']
})
export class FinancialComponent implements OnInit {

financial$: Observable<Financial[]>;
displayedColumns = ['sourceAccount','targetAccount','transferValue','rate','transferDate','appointmentDate','acctions'];

constructor(
  private financialService: FinancialService,
  public dialog: MatDialog,
  private router:Router,
  private route: ActivatedRoute ){
  this.financial$ = this.financialService.list()
.pipe(
  catchError(error =>{
    this.onError('Error loading appointments!');
    return of([])
  })
  );
}

onError(errorMsg: string){
this.dialog.open(ErrorDialogComponent,{
  data: errorMsg
});
}


ngOnInit(): void {

}


onAdd(){
  // console.log('dwsdsd');
  this.router.navigate(['new'],{relativeTo: this.route});
}



}
