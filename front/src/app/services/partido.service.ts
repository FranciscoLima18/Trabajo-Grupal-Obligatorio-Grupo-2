import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Partido } from '../interfaces/partido';

@Injectable({
  providedIn: 'root'
})
export class PartidoService {
  private apiUrl = 'http://localhost:8080/api/partidos';

  constructor(private http: HttpClient) {}

  getPartidos(): Observable<Partido[]> {
    return this.http.get<Partido[]>(this.apiUrl);
  }

  getPartido(id: number): Observable<Partido> {
    return this.http.get<Partido>(`${this.apiUrl}/${id}`);
  }

  crearPartido(data: Partido): Observable<Partido> {
    return this.http.post<Partido>(this.apiUrl, data);
  }

  actualizarPartido(id: number, data: Partido): Observable<Partido> {
    return this.http.put<Partido>(`${this.apiUrl}/${id}`, data);
  }

  eliminarPartido(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
