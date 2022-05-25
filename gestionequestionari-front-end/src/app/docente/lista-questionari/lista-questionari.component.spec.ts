import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaQuestionariComponent } from './lista-questionari.component';

describe('ListaQuestionariComponent', () => {
  let component: ListaQuestionariComponent;
  let fixture: ComponentFixture<ListaQuestionariComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListaQuestionariComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListaQuestionariComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
