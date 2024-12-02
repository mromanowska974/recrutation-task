import { Component, inject } from '@angular/core';
import { Router, RouterModule } from '@angular/router';

@Component({
  selector: 'app-currencies-menu',
  standalone: true,
  imports: [
    RouterModule
  ],
  templateUrl: './currencies-menu.component.html',
  styleUrl: './currencies-menu.component.css'
})
export class CurrenciesMenuComponent {
  router = inject(Router);

  onNavigateToRequestsList(){
    this.router.navigate(['currencies', 'requests']);
  }

  onNavigateToCurrentCurrencySelect(){
    this.router.navigate(['currencies', 'get-current-currency-value-command']);
  }
}
