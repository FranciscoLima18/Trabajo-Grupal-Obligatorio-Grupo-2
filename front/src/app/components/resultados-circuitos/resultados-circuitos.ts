import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { MesaService } from '../../services/mesa.service';
import { VotoService } from '../../services/voto.service';
import { MesaMiembroService } from '../../services/mesa-miembro.service';
import { Mesa } from '../../interfaces/mesa';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ChangeDetectorRef } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-resultados-circuito',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './resultados-circuitos.html',
  styleUrls: ['./resultados-circuitos.css']
})
export class ResultadosCircuitos implements OnInit {
  ciudadanoId!: number;
  mesa!: Mesa;
  circuitosDisponibles: { id: number; nombre: string }[] = [];
  circuitoSeleccionadoId: number | null = null;

  votosTotales = 0;
  votosValidos = 0;
  votosAnulados = 0;
  votosObservados = 0;
  votosEnBlanco = 0;

  resultadosCargados = false;
  mensaje = '';

  constructor(
    private route: ActivatedRoute,
    private mesaService: MesaService,
    private votoService: VotoService,
    private mesaMiembroService: MesaMiembroService,
    private cd: ChangeDetectorRef,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.ciudadanoId = Number(this.route.snapshot.paramMap.get('id'));

    this.mesaMiembroService.getMesaMiembros().subscribe(miembros => {
      const presidente = miembros.find(
        m => m.ciudadano.ciudadanoId === this.ciudadanoId && m.rol === 'PRESIDENTE'
      );

      if (!presidente) {
        this.mensaje = 'No tenés asignada una mesa como presidente.';
        this.cd.detectChanges();
        return;
      }

      const mesa = presidente.mesa;

      if (!mesa.fechaHoraCierre) {
        this.mensaje = 'La mesa aún no ha sido cerrada. Los resultados no están disponibles.';
        this.cd.detectChanges();
        return;
      }

      this.mesa = mesa;

      this.votoService.getVotos().subscribe(votos => {
        const circuitosUnicos = new Map<number, string>();

        votos.forEach((v: any) => {
          if (v.circuito) {
            const id = v.circuito.circuitoId;
            const nombre = `${v.circuito.departamento} - ${v.circuito.localidad}`;
            circuitosUnicos.set(id, nombre);
          }
        });

        this.circuitosDisponibles = Array.from(circuitosUnicos.entries()).map(([id, nombre]) => ({
          id,
          nombre
        }));

        if (this.circuitosDisponibles.length > 0) {
          this.circuitoSeleccionadoId = this.circuitosDisponibles[0].id;
          this.cargarResultados();
        }
        this.cd.detectChanges();
      });
    });
  }

  volverHomeCiudadano(): void {
    this.router.navigate(['/home-ciudadano', this.ciudadanoId]);
  }

  onCircuitoChange(): void {
    this.resultadosCargados = false;
    this.cargarResultados();
  }

  cargarResultados(): void {
    if (!this.circuitoSeleccionadoId) return;

    this.votoService.getVotos().subscribe(votos => {
      const votosMesa = votos.filter((v: any) => v.circuito?.circuitoId === this.circuitoSeleccionadoId);

      this.votosTotales = votosMesa.length;
      this.votosValidos = votosMesa.filter(v => v.estadoVoto === 'valido').length;
      this.votosAnulados = votosMesa.filter(v => v.estadoVoto === 'anulado').length;
      this.votosEnBlanco = votosMesa.filter(v => v.estadoVoto === 'en_blanco').length;
      this.votosObservados = votosMesa.filter(v => v.observado).length;

      this.resultadosCargados = true;
      this.cd.detectChanges();
    });
  }
}
