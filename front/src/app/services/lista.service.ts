import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Lista } from '../interfaces/lista';

@Injectable({
  providedIn: 'root'
})
export class ListaService {
  private apiUrl = 'http://localhost:8080/api/listas';

  constructor(private http: HttpClient) {}

  getListas(): Observable<Lista[]> {
    return this.http.get<Lista[]>(this.apiUrl);
  }

  getLista(id: number): Observable<Lista> {
    return this.http.get<Lista>(`${this.apiUrl}/${id}`);
  }

  crearLista(data: Lista): Observable<Lista> {
    return this.http.post<Lista>(this.apiUrl, data);
  }

  actualizarLista(id: number, data: Lista): Observable<Lista> {
    return this.http.put<Lista>(`${this.apiUrl}/${id}`, data);
  }

  eliminarLista(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
