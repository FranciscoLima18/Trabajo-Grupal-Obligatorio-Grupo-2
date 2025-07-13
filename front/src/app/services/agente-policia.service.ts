import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AgentePolicia } from '../interfaces/agente-policia';

@Injectable({
  providedIn: 'root'
})
export class AgentePoliciaService {
  private apiUrl = 'http://localhost:8080/api/agentes';

  constructor(private http: HttpClient) {}

  getAgentes(): Observable<AgentePolicia[]> {
    return this.http.get<AgentePolicia[]>(this.apiUrl);
  }

  crearAgente(data: AgentePolicia): Observable<AgentePolicia> {
    return this.http.post<AgentePolicia>(this.apiUrl, data);
  }
}
