import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { DataRequest } from './dataRequest';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  http = inject(HttpClient);

  nbpUrl = 'https://api.nbp.pl/api/exchangerates/rates/A/';
  myApiUrl = 'http://localhost:8080/currencies/';

  //get chosen currency from NBP API
  getCurrencyData(currencyCode: string){
    return this.http.get(this.nbpUrl+currencyCode+'?format=json');
  }

  //send a request with received data to database
  sendRequest(currencyCode: string, username: string, value: number){
    let newRequest: DataRequest;

    newRequest = {
      currency: currencyCode,
      name: username,
      date: new Date(),
      value: value
    }

    return this.http.post(this.myApiUrl+'get-current-currency-value-command', newRequest)
  }

  //get list of all requests that has been sent

  getAllRequests(){
    return this.http.get(this.myApiUrl+'requests');
  }
}
