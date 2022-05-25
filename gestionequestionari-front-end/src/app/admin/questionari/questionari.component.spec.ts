import { ComponentFixture, TestBed } from '@angular/core/testing';

import { QuestionariComponent } from './questionari.component';

describe('QuestionariComponent', () => {
  let component: QuestionariComponent;
  let fixture: ComponentFixture<QuestionariComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ QuestionariComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(QuestionariComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
