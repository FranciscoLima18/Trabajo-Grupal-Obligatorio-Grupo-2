import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AsignacionCircuito } from '../interfaces/asignacion-circuito';

@Injectable({
  providedIn: 'root'
})
export class AsignacionCircuitoService {
  private apiUrl = 'http://localhost:8080/api/asignaciones';

  constructor(private http: HttpClient) {}

  // Obtener todas las asignaciones
  getAll(): Observable<AsignacionCircuito[]> {
    return this.http.get<AsignacionCircuito[]>(this.apiUrl);
  }

  // Crear asignación desde DTO: { ciudadanoId: number, circuitoId: number }
  asignarCiudadano(data: { ciudadanoId: number, circuitoId: number }): Observable<AsignacionCircuito> {
    return this.http.post<AsignacionCircuito>(this.apiUrl, data);
  }

  // Eliminar asignación pasando el ID compuesto: { ciudadanoId, circuitoId }
  eliminarAsignacion(id: { ciudadanoId: number, circuitoId: number }): Observable<void> {
    return this.http.request<void>('delete', this.apiUrl, { body: id });
  }
}
