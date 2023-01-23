import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { delay, first, tap } from 'rxjs';

import { Financial } from './../model/financial';

@Injectable({
  providedIn: 'root'
})
export class FinancialService {

  private readonly API = 'api/v1/transfer/';

  constructor(private httpClient: HttpClient) { }

  list(){
    return this.httpClient.get<Financial[]>(this.API)
    .pipe(
      first(),
      delay(5000),
      tap(financial => console.log(financial))
    );

  }


  save(record: Partial<Financial>){
   return this.httpClient.post<Financial>(this.API,record).pipe(first());
  }


}
