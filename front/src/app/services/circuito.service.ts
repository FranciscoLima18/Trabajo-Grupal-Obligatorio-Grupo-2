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

  getCircuitos(): Observable<Circuito[]> {
    return this.http.get<Circuito[]>(this.apiUrl);
  }

  getCircuito(id: number): Observable<Circuito> {
    return this.http.get<Circuito>(`${this.apiUrl}/${id}`);
  }

  crearCircuito(data: Circuito): Observable<Circuito> {
    return this.http.post<Circuito>(this.apiUrl, data);
  }

  actualizarCircuito(id: number, data: Circuito): Observable<Circuito> {
    return this.http.put<Circuito>(`${this.apiUrl}/${id}`, data);
  }

  eliminarCircuito(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
