import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { MesaMiembro } from '../interfaces/mesa-miembro';

@Injectable({
  providedIn: 'root'
})
export class MesaMiembroService {
  private apiUrl = 'http://localhost:8080/api/mesa-miembros';

  constructor(private http: HttpClient) {}

  getMesaMiembros(): Observable<MesaMiembro[]> {
    return this.http.get<MesaMiembro[]>(this.apiUrl);
  }

  getPorMesa(mesaId: number): Observable<MesaMiembro[]> {
    return this.http.get<MesaMiembro[]>(`${this.apiUrl}/mesa/${mesaId}`);
  }

  asignarMiembro(data: MesaMiembro): Observable<MesaMiembro> {
    return this.http.post<MesaMiembro>(this.apiUrl, data);
  }

  eliminarMiembro(mesaId: number, ciudadanoId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/mesa/${mesaId}/ciudadano/${ciudadanoId}`);
  }
}
