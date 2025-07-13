import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Circuito } from '../interfaces/circuito';

@Injectable({
  providedIn: 'root'
})
export class CircuitoService {
  private apiUrl = 'http://localhost:8080/api/circuitos';

  constructor(private http: HttpClient) {}

  // Obtener todos los circuitos
  getCircuitos(): Observable<Circuito[]> {
    return this.http.get<Circuito[]>(this.apiUrl);
  }

  // Obtener un circuito por ID
  getCircuito(id: number): Observable<Circuito> {
    return this.http.get<Circuito>(`${this.apiUrl}/${id}`);
  }

  // Crear un nuevo circuito
  crearCircuito(data: Circuito): Observable<Circuito> {
    return this.http.post<Circuito>(this.apiUrl, data);
  }

  // Eliminar un circuito por ID
  eliminarCircuito(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
