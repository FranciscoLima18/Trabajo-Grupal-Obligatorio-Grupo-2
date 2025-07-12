import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { VotoCabecera } from '../interfaces/votocabecera';

@Injectable({
  providedIn: 'root'
})
export class VotoService {
  private apiUrl = 'http://localhost:8080/api/votos';

  constructor(private http: HttpClient) {}

  emitirVoto(voto: VotoCabecera): Observable<any> {
    return this.http.post(this.apiUrl, voto);
  }

  getVotos(): Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl);
  }

  getVotoPorCiudadano(ciudadanoId: number, eleccionId: number): Observable<any> {
    return this.http.get(`${this.apiUrl}/ciudadano/${ciudadanoId}/eleccion/${eleccionId}`);
  }
}
