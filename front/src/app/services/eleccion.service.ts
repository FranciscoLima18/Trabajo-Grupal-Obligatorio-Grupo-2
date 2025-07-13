import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Eleccion } from '../interfaces/eleccion';

@Injectable({
  providedIn: 'root'
})
export class EleccionService {
  private apiUrl = 'http://localhost:8080/api/elecciones';

  constructor(private http: HttpClient) {}

  getElecciones(): Observable<Eleccion[]> {
    return this.http.get<Eleccion[]>(this.apiUrl);
  }

  getEleccion(id: number): Observable<Eleccion> {
    return this.http.get<Eleccion>(`${this.apiUrl}/${id}`);
  }

  crearEleccion(data: Eleccion): Observable<Eleccion> {
    return this.http.post<Eleccion>(this.apiUrl, data);
  }

  actualizarEleccion(id: number, data: Eleccion): Observable<Eleccion> {
    return this.http.put<Eleccion>(`${this.apiUrl}/${id}`, data);
  }

  eliminarEleccion(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
