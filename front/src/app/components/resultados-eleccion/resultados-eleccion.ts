import { Component, OnInit } from '@angular/core';
import { VotoService } from '../../services/voto.service';
import { EleccionService } from '../../services/eleccion.service';
import { PartidoService } from '../../services/partido.service';
import { CandidatoService } from '../../services/candidato.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-resultados-eleccion',
  imports: [CommonModule],
  templateUrl: './resultados-eleccion.html',
  styleUrls: ['./resultados-eleccion.css']
})

export class ResultadosEleccion implements OnInit {
  votos: any[] = [];
  elecciones: any[] = [];
  resultadosAgrupados: any[] = [];

  constructor(
    private votoService: VotoService,
    private eleccionService: EleccionService,
    private partidoService: PartidoService,
    private candidatoService: CandidatoService
  ) {}

  ngOnInit(): void {
    this.votoService.getVotos().subscribe(votos => {
      console.log('Votos cargados:', votos);
      this.votos = votos;

      this.eleccionService.getElecciones().subscribe(elecciones => {
        this.elecciones = elecciones;
        this.generarResultados();
      });
    });
  }

  getKeys(obj: any): string[] {
    return Object.keys(obj);
  }

  generarResultados(): void {
    this.resultadosAgrupados = this.elecciones.map(eleccion => {
      const votosEleccion = this.votos.filter(v => v.eleccionId === eleccion.eleccionId);

      const porDepartamento: { [dep: string]: { validos: number; observados: number; anulados: number } } = {};
      const porPartido: { [id: number]: { validos: number; observados: number; anulados: number } } = {};
      const porCandidato: { [id: number]: { validos: number; observados: number; anulados: number } } = {};

      for (const voto of votosEleccion) {
        const dep = voto.departamento ?? 'Desconocido';
        if (!porDepartamento[dep]) {
          porDepartamento[dep] = { validos: 0, observados: 0, anulados: 0 };
        }
        if (!porPartido[voto.partidoId]) {
          porPartido[voto.partidoId] = { validos: 0, observados: 0, anulados: 0 };
        }
        if (!porCandidato[voto.candidatoId]) {
          porCandidato[voto.candidatoId] = { validos: 0, observados: 0, anulados: 0 };
        }

        const tipo = voto.observado ? 'observados' : voto.estadoVoto === 'anulado' ? 'anulados' : 'validos';

        porDepartamento[dep][tipo]++;
        porPartido[voto.partidoId][tipo]++;
        porCandidato[voto.candidatoId][tipo]++;
      }

      return {
        tipo: eleccion.tipo,
        porDepartamento,
        porPartido,
        porCandidato
      };
    });
    console.log('Resultados agrupados:', this.resultadosAgrupados);
  }
  
}
