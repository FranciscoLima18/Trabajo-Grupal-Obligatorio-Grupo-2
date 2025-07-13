import { Component } from '@angular/core';
import { CiudadanoService } from '../../services/ciudadano.service';
import { Router } from '@angular/router';
import { Ciudadano } from '../../interfaces/ciudadano';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-registro',
  standalone: true,
  imports: [FormsModule, RouterModule],
  templateUrl: './registro.html',
  styleUrls: ['./registro.css']
})
export class RegistroComponent {

  ciudadano: Partial<Ciudadano> = {};

  constructor(
    private ciudadanoService: CiudadanoService,
    private router: Router
  ) {}

  registrar() {
    if (
      this.ciudadano.ci &&
      this.ciudadano.cc &&
      this.ciudadano.nombreCompleto &&
      this.ciudadano.fechaNacimiento
    ) {
      this.ciudadanoService.crearCiudadano(this.ciudadano as Ciudadano)
        .subscribe(() => {
          alert('Registro exitoso');
          this.router.navigate(['']);
        });
    }
  }
}
