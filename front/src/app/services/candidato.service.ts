import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Candidato } from '../interfaces/candidato';

@Injectable({
  providedIn: 'root'
})
export class CandidatoService {
  private apiUrl = 'http://localhost:8080/api/candidatos';

  constructor(private http: HttpClient) {}

  getCandidatos(): Observable<Candidato[]> {
    return this.http.get<Candidato[]>(this.apiUrl);
  }

  getCandidato(id: number): Observable<Candidato> {
    return this.http.get<Candidato>(`${this.apiUrl}/${id}`);
  }

  crearCandidato(data: Candidato): Observable<Candidato> {
    return this.http.post<Candidato>(this.apiUrl, data);
  }

  actualizarCandidato(id: number, data: Candidato): Observable<Candidato> {
    return this.http.put<Candidato>(`${this.apiUrl}/${id}`, data);
  }

  eliminarCandidato(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
