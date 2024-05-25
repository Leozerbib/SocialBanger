import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardAmisComponent } from './card-amis.component';

describe('CardAmisComponent', () => {
  let component: CardAmisComponent;
  let fixture: ComponentFixture<CardAmisComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CardAmisComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CardAmisComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
