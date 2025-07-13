import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Ciudadano } from '../interfaces/ciudadano';

@Injectable({
  providedIn: 'root'
})

export class CiudadanoService {
  private apiUrl = 'http://localhost:8080/api/ciudadanos';

  constructor(private http: HttpClient) {}

  getCiudadanos(): Observable<Ciudadano[]> {
    return this.http.get<Ciudadano[]>(this.apiUrl);
  }

  getCiudadano(id: number): Observable<Ciudadano> {
    return this.http.get<Ciudadano>(`${this.apiUrl}/${id}`);
  }

  crearCiudadano(data: Ciudadano): Observable<Ciudadano> {
    return this.http.post<Ciudadano>(this.apiUrl, data);
  }

  actualizarCiudadano(id: number, data: Ciudadano): Observable<Ciudadano> {
    return this.http.put<Ciudadano>(`${this.apiUrl}/${id}`, data);
  }

  eliminarCiudadano(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
