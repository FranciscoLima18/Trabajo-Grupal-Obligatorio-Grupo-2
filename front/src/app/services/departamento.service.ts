import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Departamento } from '../interfaces/departamento';

@Injectable({
  providedIn: 'root'
})
export class DepartamentoService {
  private apiUrl = 'http://localhost:8080/api/departamentos';

  constructor(private http: HttpClient) {}

  getDepartamentos(): Observable<Departamento[]> {
    return this.http.get<Departamento[]>(this.apiUrl);
  }

  getDepartamento(id: number): Observable<Departamento> {
    return this.http.get<Departamento>(`${this.apiUrl}/${id}`);
  }

  crearDepartamento(data: Departamento): Observable<Departamento> {
    return this.http.post<Departamento>(this.apiUrl, data);
  }

  actualizarDepartamento(id: number, data: Departamento): Observable<Departamento> {
    return this.http.put<Departamento>(`${this.apiUrl}/${id}`, data);
  }

  eliminarDepartamento(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
