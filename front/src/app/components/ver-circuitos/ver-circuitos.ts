import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CircuitoService } from '../../services/circuito.service';
import { AsignacionCircuitoService } from '../../services/asignacion-circuito.service';
import { Circuito } from '../../interfaces/circuito';
import { AsignacionCircuito } from '../../interfaces/asignacion-circuito';
import { CommonModule } from '@angular/common';
import { ChangeDetectorRef } from '@angular/core';
import { Router } from '@angular/router';


@Component({
  selector: 'app-ver-circuitos',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './ver-circuitos.html',
  styleUrls: ['./ver-circuitos.css']
})
export class VerCircuitos implements OnInit {
  ciudadanoId!: number;
  circuitos: Circuito[] = [];
  asignaciones: AsignacionCircuito[] = [];
  circuitoAsignadoIds: number[] = [];

  constructor(
    private circuitoService: CircuitoService,
    private asignacionService: AsignacionCircuitoService,
    private route: ActivatedRoute,
    private cd: ChangeDetectorRef,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.ciudadanoId = Number(this.route.snapshot.paramMap.get('id'));

    this.circuitoService.getCircuitos().subscribe({
      next: (data) => {
        this.circuitos = data;
        this.cd.detectChanges();
      },
      error: () => alert('Error al cargar circuitos')
    });
    

    this.asignacionService.getAll().subscribe({
      next: (data) => {
        console.log('Asignaciones:', data);
        this.asignaciones = data;
        this.circuitoAsignadoIds = data
          .filter(a => a.ciudadano?.ciudadanoId === this.ciudadanoId)
          .map(a => a.circuito?.circuitoId)
          .filter((id): id is number => typeof id === 'number');
        this.cd.detectChanges();
      },
      error: () => alert('Error al cargar asignaciones')
    });

  }

  volver(): void {
    this.router.navigate(['/home-ciudadano', this.ciudadanoId]);
  }

  estaAsignado(circuitoId: number): boolean {
    return this.circuitoAsignadoIds.includes(circuitoId);
  }
}

