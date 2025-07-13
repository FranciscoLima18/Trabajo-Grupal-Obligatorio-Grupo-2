import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { MesaMiembroService } from '../../services/mesa-miembro.service';
import { MesaMiembro } from '../../interfaces/mesa-miembro';
import { CiudadanoService } from '../../services/ciudadano.service';
import { Ciudadano } from '../../interfaces/ciudadano';
import { MesaService } from '../../services/mesa.service';
import { Mesa } from '../../interfaces/mesa';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { ChangeDetectorRef } from '@angular/core';
import { Router } from '@angular/router';


@Component({
  selector: 'app-home-mesa',
  templateUrl: './home-mesa.html',
  imports: [CommonModule, RouterModule],
  styleUrls: ['./home-mesa.css']
})
export class HomeMesa implements OnInit {
  ciudadanoId!: number;
  ciudadano?: Ciudadano;
  mesaAsignada?: Mesa;
  mesaMiembro: MesaMiembro | null = null;
  estadoMesa = '';
  mensaje = '';

  constructor(
    private route: ActivatedRoute,
    private ciudadanoService: CiudadanoService,
    private mesaService: MesaService,
    private mesaMiembroService: MesaMiembroService,
    private cd: ChangeDetectorRef,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.ciudadanoId = Number(this.route.snapshot.paramMap.get('id'));
    console.log('ID recibido:', this.ciudadanoId);

      this.ciudadanoService.getCiudadano(this.ciudadanoId).subscribe(c => {
      this.ciudadano = c;

      this.mesaMiembroService.getPorCiudadano(this.ciudadanoId).subscribe((miembros: any[]) => {
      const miembro = miembros.find(m => m.rol?.toLowerCase() === 'presidente');

        if (miembro && miembro.mesa?.mesaId && miembro.ciudadano?.ciudadanoId) {
          this.mesaMiembro = {
            mesa: miembro.mesa.mesaId,
            ciudadano: miembro.ciudadano.ciudadanoId,
            rol: miembro.rol,
            organismo: miembro.organismo
          };

          this.mesaService.getMesa(miembro.mesa.mesaId).subscribe(mesa => {
            this.mesaAsignada = mesa;
            this.estadoMesa = mesa.fechaHoraCierre ? 'CERRADA' : 'ABIERTA';
            this.cd.detectChanges();
          });
        }
      });
    });
  }

  volverHomeCiudadano(): void {
    this.router.navigate(['/home-ciudadano', this.ciudadanoId]);
  }

  cerrarMesa(): void {
    if (this.mesaAsignada?.mesaId) {
      this.mesaService.cerrarMesa(this.mesaAsignada.mesaId).subscribe(() => {
        this.estadoMesa = 'CERRADA';
        this.mensaje = 'La mesa ha sido cerrada correctamente.';
      });
    }
  }
}
