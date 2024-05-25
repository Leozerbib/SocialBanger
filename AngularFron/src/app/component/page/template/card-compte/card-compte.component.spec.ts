import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardCompteComponent } from './card-compte.component';

describe('CardCompteComponent', () => {
  let component: CardCompteComponent;
  let fixture: ComponentFixture<CardCompteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CardCompteComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CardCompteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
