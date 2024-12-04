import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { DataRequest } from './dataRequest';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  http = inject(HttpClient);
  myApiUrl = 'http://localhost:8080/currencies/';

  //send a request with received data to database
  getCurrencyValue(currencyCode: string, username: string){
    let newRequest = {
      currency: currencyCode,
      name: username,
    }

    return this.http.post(this.myApiUrl+'get-current-currency-value-command', newRequest)
  }

  //get list of all requests that has been sent

  getAllRequests(){
    return this.http.get(this.myApiUrl+'requests');
  }
}
