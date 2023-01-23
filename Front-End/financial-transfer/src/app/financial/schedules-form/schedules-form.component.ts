import { MatSnackBar } from '@angular/material/snack-bar';
import { Component,OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Location } from '@angular/common';
import { NonNullableFormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';

import { FinancialService } from './../services/financial.service';

@Component({
  selector: 'app-schedules-form',
  templateUrl: './schedules-form.component.html',
  styleUrls: ['./schedules-form.component.scss']
})
export class SchedulesFormComponent implements OnInit {

form = this.formBuilder.group({
  sourceAccount: [''],
  targetAccount: [''],
  transferValue: [''],
  transferDate:  ['']
});

  constructor(
    private formBuilder: NonNullableFormBuilder,
    private service: FinancialService,
    private snackBar: MatSnackBar,
    private location: Location){

  }

  ngOnInit(): void{

  }


  onSubmit() {
    this.service.save(this.form.value)
      .subscribe(result => this.onSuccess(), error => this.onError());
  }

  onCancel() {
    this.location.back();
  }

  private onSuccess() {
    this.snackBar.open('Agendamento salvo com sucesso!', '', { duration: 5000 });
    this.onCancel();
  }

  private onError() {
    this.snackBar.open('Erro ao salvar agendamento. '+
    'Verifique se as contas existem. '+
    'O valor e maior que 1 ou a data e maior que hoje! (xxxx-xx-xx)', '', { duration: 5000 });
  }

  getErrorMessage(fieldName: string) {
    const field = this.form.get(fieldName);

    if (field?.hasError('required')) {
      return 'Campo obrigatório';
    }

    if (field?.hasError('minlength')) {
      const requiredLength: number = field.errors ? field.errors['minlength']['requiredLength'] : 5;
      return `Tamanho mínimo precisa ser de ${requiredLength} caracteres.`;
    }

    if (field?.hasError('maxlength')) {
      const requiredLength: number = field.errors ? field.errors['maxlength']['requiredLength'] : 200;
      return `Tamanho máximo excedido de ${requiredLength} caracteres.`;
    }

    return 'Campo Inválido';
  }


}
