import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ApiResponse, IEmployee } from '../pages/shared/models/Employee';

@Injectable({
  providedIn: 'root',
})
export class EmployeeService {
  apiurl = 'http://localhost:3000/employees';
  constructor(private http: HttpClient) {}

  getAllEmployee(): Observable<ApiResponse<IEmployee[]>>{
    return this.http.get<ApiResponse<IEmployee[]>>(this.apiurl);
  }

  getEmployeeById(id:string): Observable<ApiResponse<IEmployee>>{
    return this.http.get<ApiResponse<IEmployee>>(`${this.apiurl}/${id}`);
  }

  createEmployee(employee:IEmployee): Observable<ApiResponse<IEmployee>>{
    return this.http.post<ApiResponse<IEmployee>>(this.apiurl, employee);
  }

  updateEmployee(id:string, employee:IEmployee): Observable<ApiResponse<IEmployee>>{
    return this.http.put<ApiResponse<IEmployee>>(`${this.apiurl}/${id}`, employee);
  }

  delteEmployee(id:string): Observable<ApiResponse<IEmployee>>{
    return this.http.delete<ApiResponse<IEmployee>>(`${this.apiurl}/${id}`);
  }
}