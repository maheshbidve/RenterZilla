import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GoogleMapDisplayComponent } from './google-map-display.component';

describe('GoogleMapDisplayComponent', () => {
  let component: GoogleMapDisplayComponent;
  let fixture: ComponentFixture<GoogleMapDisplayComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GoogleMapDisplayComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GoogleMapDisplayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
