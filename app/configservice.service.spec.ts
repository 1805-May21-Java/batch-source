import { TestBed, inject } from '@angular/core/testing';

import { ConfigserviceService } from './configservice.service';

describe('ConfigserviceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ConfigserviceService]
    });
  });

  it('should be created', inject([ConfigserviceService], (service: ConfigserviceService) => {
    expect(service).toBeTruthy();
  }));
});
