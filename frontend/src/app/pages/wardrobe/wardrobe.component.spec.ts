import { ComponentFixture, TestBed } from '@angular/core/testing';
import { provideRouter } from '@angular/router';
import { of } from 'rxjs';

import { WardrobeComponent } from './wardrobe.component';
import { WardrobeService } from '../../services/wardrobe.service';

describe('WardrobeComponent', () => {
  let component: WardrobeComponent;
  let fixture: ComponentFixture<WardrobeComponent>;
  const wardrobeServiceMock = {
    getClothes: () => of([])
  };

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [WardrobeComponent],
      providers: [
        provideRouter([]),
        { provide: WardrobeService, useValue: wardrobeServiceMock }
      ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(WardrobeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
