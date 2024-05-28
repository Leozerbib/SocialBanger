import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardInfoProfileComponent } from './card-info-profile.component';

describe('CardInfoProfileComponent', () => {
  let component: CardInfoProfileComponent;
  let fixture: ComponentFixture<CardInfoProfileComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CardInfoProfileComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CardInfoProfileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
