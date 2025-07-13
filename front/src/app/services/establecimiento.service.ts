import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Establecimiento } from '../interfaces/establecimiento';

@Injectable({
  providedIn: 'root'
})
export class EstablecimientoService {
  private apiUrl = 'http://localhost:8080/api/establecimientos';

  constructor(private http: HttpClient) {}

  getEstablecimientos(): Observable<Establecimiento[]> {
    return this.http.get<Establecimiento[]>(this.apiUrl);
  }

  crearEstablecimiento(data: Establecimiento): Observable<Establecimiento> {
    return this.http.post<Establecimiento>(this.apiUrl, data);
  }
}
