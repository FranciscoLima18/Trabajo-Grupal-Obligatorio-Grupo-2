import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { CiudadanoService } from '../../services/ciudadano.service';

@Component({
  selector: 'app-login',
  imports: [CommonModule, ReactiveFormsModule, RouterModule],
  templateUrl: './login.html',
  styleUrl: './login.css'
})
export class Login {
loginForm!: FormGroup;
  errorMsg = '';

  // CI hardcodeado del presidente de mesa
  presidenteCI = '11111111';

  constructor(
    private fb: FormBuilder,
    private ciudadanoService: CiudadanoService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.loginForm = this.fb.group({
      ci: ['', Validators.required]
    });
  }

  onSubmit(): void {
    const ciIngresado = this.loginForm.value.ci;

    this.ciudadanoService.getCiudadanos().subscribe(ciudadanos => {
      const ciudadano = ciudadanos.find(c => c.ci === ciIngresado);

      if (ciudadano) {
        if (ciIngresado === this.presidenteCI) {
          this.router.navigate([`/home-mesa`, ciudadano.ciudadanoId]);
        } else {
          this.router.navigate([`/home-ciudadano`, ciudadano.ciudadanoId]);
        }
      } else {
        this.errorMsg = 'Cédula no registrada';
      }
    });
  }
}
