import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardAcountInfoComponent } from './card-acount-info.component';

describe('CardAcountInfoComponent', () => {
  let component: CardAcountInfoComponent;
  let fixture: ComponentFixture<CardAcountInfoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CardAcountInfoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CardAcountInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
