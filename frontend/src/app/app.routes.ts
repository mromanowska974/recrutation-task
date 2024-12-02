import { Routes } from '@angular/router';
import { CurrentCurrencySelectComponent } from './current-currency-select/current-currency-select.component';
import { RequestsListComponent } from './requests-list/requests-list.component';
import { CurrenciesMenuComponent } from './currencies-menu/currencies-menu.component';

export const routes: Routes = [
  {
    path: 'currencies',
    component: CurrenciesMenuComponent,
    children: [
      {
        path: 'get-current-currency-value-command',
        component: CurrentCurrencySelectComponent
      },
      {
        path: 'requests',
        component: RequestsListComponent
      }
    ]
  },
  {
    path: '',
    redirectTo: 'currencies',
    pathMatch: 'full'
  }
];
