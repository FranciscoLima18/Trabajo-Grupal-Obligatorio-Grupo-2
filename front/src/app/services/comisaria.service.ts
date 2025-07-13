import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Comisaria } from '../interfaces/comisaria';

@Injectable({
  providedIn: 'root'
})
export class ComisariaService {
  private apiUrl = 'http://localhost:8080/api/comisarias';

  constructor(private http: HttpClient) {}

  getComisarias(): Observable<Comisaria[]> {
    return this.http.get<Comisaria[]>(this.apiUrl);
  }

  crearComisaria(data: Comisaria): Observable<Comisaria> {
    return this.http.post<Comisaria>(this.apiUrl, data);
  }
}
