import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-login',
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './login.html',
  styleUrl: './login.css'
})
export class Login {
  loginForm: FormGroup;
  errorMsg = '';

  constructor(private fb: FormBuilder, private router: Router) {
    this.loginForm = this.fb.group({
      ci: ['', [Validators.required]],
    });
  }

  onSubmit() {
    const { ci } = this.loginForm.value;

    // Simulación de login solo con CI (reemplazar con llamada al servicio)
    if (ci === '12345678') {
      this.router.navigate(['/mesa']);
    } else if (ci === '87654321') {
      this.router.navigate(['/home-ciudadano']);
    } else {
      this.errorMsg = 'CI incorrecta';
    }
  }
}
