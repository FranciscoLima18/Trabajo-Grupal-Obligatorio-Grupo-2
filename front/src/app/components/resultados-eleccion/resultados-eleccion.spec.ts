import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ResultadosEleccion } from './resultados-eleccion';

describe('ResultadosEleccion', () => {
  let component: ResultadosEleccion;
  let fixture: ComponentFixture<ResultadosEleccion>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ResultadosEleccion]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ResultadosEleccion);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
