import { TestBed, inject } from '@angular/core/testing';

import { AadharCardService } from './aadhar-card.service';

describe('AadharCardService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AadharCardService]
    });
  });

  it('should be created', inject([AadharCardService], (service: AadharCardService) => {
    expect(service).toBeTruthy();
  }));
});
