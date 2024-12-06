import { Component, inject, OnInit } from '@angular/core';
import { ApiService } from '../api.service';
import { DataRequest } from '../dataRequest';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-requests-list',
  standalone: true,
  imports: [
    CommonModule
  ],
  templateUrl: './requests-list.component.html',
  styleUrl: './requests-list.component.css'
})
export class RequestsListComponent implements OnInit{
  apiService = inject(ApiService);

  allRequests: DataRequest[] = [];

  ngOnInit(): void {
      this.apiService.getAllRequests().subscribe(requests => {
        this.allRequests = Object.values(requests).map(request => {
          let item: DataRequest = JSON.parse(JSON.stringify(request));
          return item;
        });
      });
  }
}
