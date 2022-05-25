import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SidenavDocenteComponent } from './sidenav-docente.component';

describe('SidenavDocenteComponent', () => {
  let component: SidenavDocenteComponent;
  let fixture: ComponentFixture<SidenavDocenteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SidenavDocenteComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SidenavDocenteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
