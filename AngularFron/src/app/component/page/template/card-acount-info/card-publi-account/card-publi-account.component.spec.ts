import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardPubliAccountComponent } from './card-publi-account.component';

describe('CardPubliAccountComponent', () => {
  let component: CardPubliAccountComponent;
  let fixture: ComponentFixture<CardPubliAccountComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CardPubliAccountComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CardPubliAccountComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
