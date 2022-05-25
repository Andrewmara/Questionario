import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreaPageComponent } from './crea-page.component';

describe('CreaPageComponent', () => {
  let component: CreaPageComponent;
  let fixture: ComponentFixture<CreaPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreaPageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CreaPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
