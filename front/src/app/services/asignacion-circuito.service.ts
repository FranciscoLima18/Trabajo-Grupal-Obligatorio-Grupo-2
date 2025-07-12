import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AsignacionCircuito } from '../interfaces/asignacion-circuito';

@Injectable({
  providedIn: 'root'
})
export class AsignacionCircuitoService {
  private apiUrl = 'http://localhost:8080/api/asignacion-circuito';

  constructor(private http: HttpClient) {}

  asignarCiudadano(data: AsignacionCircuito): Observable<any> {
    return this.http.post(this.apiUrl, data);
  }

  getAsignacion(ciudadanoId: number): Observable<AsignacionCircuito> {
    return this.http.get<AsignacionCircuito>(`${this.apiUrl}/ciudadano/${ciudadanoId}`);
  }
}
