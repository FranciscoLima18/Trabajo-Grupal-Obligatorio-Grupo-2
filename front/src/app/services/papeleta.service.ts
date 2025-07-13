import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Papeleta } from '../interfaces/papeleta';

@Injectable({
  providedIn: 'root'
})
export class PapeletaService {
  private apiUrl = 'http://localhost:8080/api/papeletas';

  constructor(private http: HttpClient) {}

  getPapeletas(): Observable<Papeleta[]> {
    return this.http.get<Papeleta[]>(this.apiUrl);
  }

  getPapeleta(id: number): Observable<Papeleta> {
    return this.http.get<Papeleta>(`${this.apiUrl}/${id}`);
  }

  crearPapeleta(data: Papeleta): Observable<Papeleta> {
    return this.http.post<Papeleta>(this.apiUrl, data);
  }

  actualizarPapeleta(id: number, data: Papeleta): Observable<Papeleta> {
    return this.http.put<Papeleta>(`${this.apiUrl}/${id}`, data);
  }

  eliminarPapeleta(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
