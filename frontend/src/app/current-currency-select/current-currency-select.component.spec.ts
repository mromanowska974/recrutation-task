import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CurrentCurrencySelectComponent } from './current-currency-select.component';

describe('CurrentCurrencySelectComponent', () => {
  let component: CurrentCurrencySelectComponent;
  let fixture: ComponentFixture<CurrentCurrencySelectComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CurrentCurrencySelectComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CurrentCurrencySelectComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
