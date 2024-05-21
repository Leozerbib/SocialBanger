import { TestBed } from '@angular/core/testing';

import { UerServiceService } from './uer-service.service';

describe('UerServiceService', () => {
  let service: UerServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UerServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
