import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreaQuestionarioComponent } from './crea-questionario.component';

describe('CreaQuestionarioComponent', () => {
  let component: CreaQuestionarioComponent;
  let fixture: ComponentFixture<CreaQuestionarioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreaQuestionarioComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CreaQuestionarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
