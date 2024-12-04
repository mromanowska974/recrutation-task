import { Component, inject, ViewChild } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';
import { ApiService } from '../api.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-current-currency-select',
  standalone: true,
  imports: [
    FormsModule,
    CommonModule
  ],
  templateUrl: './current-currency-select.component.html',
  styleUrl: './current-currency-select.component.css'
})
export class CurrentCurrencySelectComponent {
  @ViewChild('dataForm') dataForm: NgForm;

  apiService = inject(ApiService);

  data: {
    code: string,
    value: number
  } | null;

  errorMsg: string = '';

  onSubmitData(){
    this.errorMsg = '';
    this.data = null;

    let code = this.dataForm.value.code;
    this.apiService.getCurrencyValue(this.dataForm.value.code, this.dataForm.value.name).subscribe({
      next: (value) => {
        this.data = {
          code: code,
          value: +value
        }
      },
      error: error => {
        console.log(error);
        this.errorMsg = 'The currency with entered value doesn\'t exist.';
      }
    });
  }
}
