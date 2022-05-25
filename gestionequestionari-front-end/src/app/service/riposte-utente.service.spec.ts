import { TestBed } from '@angular/core/testing';

import { RiposteUtenteService } from './riposte-utente.service';

describe('RiposteUtenteService', () => {
  let service: RiposteUtenteService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RiposteUtenteService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
