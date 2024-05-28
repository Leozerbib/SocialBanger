import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardProfileInfoComponent } from './card-profile-info.component';

describe('CardProfileInfoComponent', () => {
  let component: CardProfileInfoComponent;
  let fixture: ComponentFixture<CardProfileInfoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CardProfileInfoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CardProfileInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
