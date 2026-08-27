import { TestBed } from '@angular/core/testing';
import { provideHttpClient } from '@angular/common/http';
import { provideHttpClientTesting } from '@angular/common/http/testing';

import { WardrobeService } from './wardrobe.service';

describe('WardrobeService', () => {
  let service: WardrobeService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [provideHttpClient(), provideHttpClientTesting()]
    });
    service = TestBed.inject(WardrobeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
