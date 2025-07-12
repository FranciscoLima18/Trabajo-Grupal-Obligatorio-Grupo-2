import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { EstadoMesa } from '../interfaces/estado-mesa';

@Injectable({
  providedIn: 'root'
})
export class EstadoMesaService {
  private apiUrl = 'http://localhost:8080/estado-mesas';

  constructor(private http: HttpClient) {}

  getEstados(): Observable<EstadoMesa[]> {
    return this.http.get<EstadoMesa[]>(this.apiUrl);
  }
}
