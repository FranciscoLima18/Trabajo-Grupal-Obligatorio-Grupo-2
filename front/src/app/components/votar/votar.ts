import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CiudadanoService } from '../../services/ciudadano.service';
import { VotoService } from '../../services/voto.service';
import { CircuitoService } from '../../services/circuito.service';
import { EleccionService } from '../../services/eleccion.service';
import { ListaService } from '../../services/lista.service';
import { PapeletaService } from '../../services/papeleta.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ChangeDetectorRef } from '@angular/core';
import { PartidoService } from '../../services/partido.service';

@Component({
  selector: 'app-votar',
  imports: [CommonModule, FormsModule],
  templateUrl: './votar.html',
  styleUrls: ['./votar.css']
})
export class Votar implements OnInit {
  ciudadanoId!: number;
  eleccionId!: number;
  ciudadano: any;
  circuitoSeleccionadoId!: number;
  elecciones: any[] = [];
  listas: any[] = [];
  partido: any;
  papeletas: any[] = [];
  seleccionadasListas: number[] = [];
  seleccionadasPapeletas: number[] = [];
  mensaje = '';
  eleccionActual: any;
  circuitos: any[] = [];
  partidos: any[] = [];

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private ciudadanoService: CiudadanoService,
    private circuitoService: CircuitoService,
    private eleccionService: EleccionService,
    private listaService: ListaService,
    private papeletaService: PapeletaService,
    private votoService: VotoService,
    private partidoService: PartidoService,
    private cd: ChangeDetectorRef
  ) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      this.ciudadanoId = Number(params.get('ciudadanoId'));
      this.eleccionId = Number(params.get('eleccionId'));
    });

    this.ciudadanoService.getCiudadano(this.ciudadanoId).subscribe(ciudadano => {
      this.ciudadano = ciudadano;

      this.circuitoService.getCircuitos().subscribe(circuitos => {
        this.circuitos = circuitos;
        this.cd.detectChanges();
      });
    });

    this.eleccionService.getElecciones().subscribe(elecciones => {
      this.elecciones = elecciones;
      this.eleccionActual = elecciones.find(e => e.eleccionId === this.eleccionId);

      this.partidoService.getPartidos().subscribe(partidos => {
        this.partidos = partidos;
        console.log('Partidos:', this.partidos);

        this.listaService.getListas().subscribe(listas => {
          if (['presidencial', 'municipal', 'ballotage'].includes(this.eleccionActual?.tipo)) {
            this.listas = listas;
          } else {
            this.listas = [];
          }
          this.cd.detectChanges();
        });
      });

      this.papeletaService.getPapeletas().subscribe(papeletas => {
        console.log('TODAS las papeletas:', papeletas);
      this.papeletas = papeletas.filter(p => p.eleccion?.eleccionId === this.eleccionId);
        console.log('Papeletas visibles:', this.papeletas);
        this.cd.detectChanges();
      });

    });
  }

  getNombrePartido(partidoId: any): string {
    const id = Number(partidoId);
    const partido = this.partidos.find(p =>
      Number(p.partidoId ?? p.partido_id) === id
    );
    return partido ? partido.nombre : 'Partido desconocido';
  }


  toggleLista(id: number): void {
    const index = this.seleccionadasListas.indexOf(id);
    if (index === -1) this.seleccionadasListas.push(id);
    else this.seleccionadasListas.splice(index, 1);
  }

  togglePapeleta(id: number): void {
    const index = this.seleccionadasPapeletas.indexOf(id);
    if (index === -1) this.seleccionadasPapeletas.push(id);
    else this.seleccionadasPapeletas.splice(index, 1);
  }

  volverHomeCiudadano(): void {
    this.router.navigate(['/home-ciudadano', this.ciudadanoId]);
  }

  emitirVoto(): void {
    let estado: 'valido' | 'en_blanco' | 'anulado' = 'valido';

    if (this.seleccionadasListas.length === 0 && this.seleccionadasPapeletas.length === 0) {
      estado = 'en_blanco';
    } else if (this.seleccionadasListas.length > 1) {
      const partidos = this.listas
        .filter(l => this.seleccionadasListas.includes(l.listaId))
        .map(l => l.partidoId);
      const distintos = new Set(partidos);
      if (distintos.size > 1) estado = 'anulado';
    }

    const votoPayload = {
      ciudadanoId: this.ciudadanoId,
      circuitoId: this.circuitoSeleccionadoId,
      eleccionId: this.eleccionId,
      estadoVoto: estado,
      observado: false,
      causalAnulacion: undefined,
      fechaHora: new Date().toISOString() 
    };

    console.log('Enviando voto:', votoPayload);

    
    this.votoService.emitirVoto(votoPayload).subscribe({
      next: () => {
        this.mensaje = '¡Voto registrado correctamente!';
        this.router.navigate(['/home-ciudadano', this.ciudadanoId]);
      },
      error: (err) => {
        console.error('Error al emitir el voto:', err);
      }
    });
  }

}
