import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { DetalleVoto } from '../interfaces/detalle-voto';

@Injectable({
  providedIn: 'root'
})

export class DetalleVotoService {
  private apiUrl = 'http://localhost:8080/api/detalles-voto';

  constructor(private http: HttpClient) {}

  getDetalles(): Observable<DetalleVoto[]> {
    return this.http.get<DetalleVoto[]>(this.apiUrl);
  }

  crearDetalle(data: DetalleVoto): Observable<DetalleVoto> {
    return this.http.post<DetalleVoto>(this.apiUrl, data);
  }

  getPorVoto(votoId: number): Observable<DetalleVoto[]> {
    return this.http.get<DetalleVoto[]>(`${this.apiUrl}/voto/${votoId}`);
  }
}
