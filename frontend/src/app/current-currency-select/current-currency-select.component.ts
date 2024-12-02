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
  };

  onSubmitData(){
    console.log(this.dataForm.value);

    this.apiService.getCurrencyData(this.dataForm.value.code).subscribe((data: any) => {
      console.log(data);
      this.data = {
        code: data.code,
        value: data.rates[0].mid.toFixed(2)
      }
    });
  }
}
