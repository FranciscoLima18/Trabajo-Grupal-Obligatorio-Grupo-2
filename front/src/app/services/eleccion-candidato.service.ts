import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { EleccionCandidato } from '../interfaces/eleccion-candidato';

@Injectable({
  providedIn: 'root'
})
export class EleccionCandidatoService {
  private apiUrl = 'http://localhost:8080/eleccion-candidatos';

  constructor(private http: HttpClient) {}

  getEleccionCandidatos(): Observable<EleccionCandidato[]> {
    return this.http.get<EleccionCandidato[]>(this.apiUrl);
  }

  crearEleccionCandidato(data: EleccionCandidato): Observable<EleccionCandidato> {
    return this.http.post<EleccionCandidato>(this.apiUrl, data);
  }
}
