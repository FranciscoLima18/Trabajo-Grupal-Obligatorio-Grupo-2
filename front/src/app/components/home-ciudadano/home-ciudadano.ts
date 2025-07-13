import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CiudadanoService } from '../../services/ciudadano.service';
import { EleccionService } from '../../services/eleccion.service';
import { VotoService } from '../../services/voto.service';
import { Ciudadano } from '../../interfaces/ciudadano';
import { Eleccion } from '../../interfaces/eleccion';
import { CommonModule } from '@angular/common';
import { ChangeDetectorRef } from '@angular/core';
import { MesaMiembroService } from '../../services/mesa-miembro.service';


@Component({
  selector: 'app-home-ciudadano',
  imports: [CommonModule],
  standalone: true,
  templateUrl: './home-ciudadano.html',
  styleUrls: ['./home-ciudadano.css']
})
export class HomeCiudadano implements OnInit {
  ciudadanoId!: number;
  ciudadano: Ciudadano | null = null;
  elecciones: Eleccion[] = [];
  votosEmitidos: number[] = [];
  esPresidente: boolean = false;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private ciudadanoService: CiudadanoService,
    private eleccionService: EleccionService,
    private votoService: VotoService,
    private cd: ChangeDetectorRef,
    private mesaMiembroService: MesaMiembroService
  ) {}

  ngOnInit(): void {
    const paramId = this.route.snapshot.paramMap.get('id');
    const storedId = localStorage.getItem('ciudadanoId');

    this.ciudadanoId = paramId
      ? Number(paramId)
      : storedId
      ? Number(storedId)
      : 0;

    if (!this.ciudadanoId || isNaN(this.ciudadanoId)) {
      alert('No se pudo recuperar el ID del ciudadano. Redirigiendo al login...');
      this.router.navigate(['/']);
      return;
    }

    console.log('ID del ciudadano:', this.ciudadanoId);

    localStorage.setItem('ciudadanoId', this.ciudadanoId.toString());

    this.ciudadanoService.getCiudadano(this.ciudadanoId).subscribe({
      next: (data) => {
        console.log('Datos del ciudadano:', data);
        this.ciudadano = data;
        this.cd.detectChanges();
      },
      error: (err) => {
        console.error('Error al obtener ciudadano', err);
        alert('Error al obtener ciudadano');
      }
    });

    

    this.mesaMiembroService.getPorCiudadano(this.ciudadanoId).subscribe({
      next: (miembros) => {
        this.esPresidente = miembros.some(m => m.rol === 'PRESIDENTE');
      },
      error: () => {
        console.warn('No se pudo verificar si es presidente de mesa');
      }
    });

    this.eleccionService.getElecciones().subscribe({
      next: (elecciones) => {
        console.log('Elecciones:', elecciones);
        this.elecciones = elecciones;

        this.votoService.getVotos().subscribe({
          next: (votos) => {
            this.votosEmitidos = votos
            .filter(v => v.ciudadano?.ciudadanoId === this.ciudadanoId)
            .map(v => v.eleccion?.eleccionId);
            console.log('Votos emitidos:', this.votosEmitidos);
            this.cd.detectChanges();
          },
          error: () => alert('Error al obtener votos')
        });
      },
      error: () => alert('Error al obtener elecciones')
    });
  }

  irAVotar(eleccionId: number): void {
    this.router.navigate(['/votar', this.ciudadanoId, eleccionId]);
  }

  verCircuitos(): void {
    this.router.navigate(['/circuitos', this.ciudadanoId]);
  }

  iraResultadosElecciones(): void {
    this.router.navigate(['/resultados-eleccion']);
  }
  
  yaVoto(eleccionId: number): boolean {
    return this.votosEmitidos.includes(+eleccionId);
  }

  cerrarSesion(): void {
    localStorage.removeItem('ciudadanoId');
    this.router.navigate(['/']);
  }

  irAHomeMesa(): void {
    this.router.navigate(['/home-mesa', this.ciudadanoId]);
  }

}


