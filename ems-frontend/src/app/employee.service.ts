import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from './employee';
import { Router } from '@angular/router';
const baseURL = "http://localhost:8080/employees";
const url2 = "http://localhost:8080/employee";
@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  
  constructor(private httpClient: HttpClient,
    private router: Router) {}


  getEmployeesList(): Observable<Employee[]>{
    return this.httpClient.get<Employee[]>(baseURL);
  }


  getEmployee(id: number){
    this.router.navigate(['employee', id]);
  }

  getEmployeeById(id: number):Observable<Employee>{
    return this.httpClient.get<Employee>(`${url2}/${id}`);
  }
  

  createEmployee(employee: Employee): Observable<Object>{
    return this.httpClient.post(baseURL, employee);
  }


  updateEmployeeById(id: number, employee: Employee): Observable<Object>{
    return this.httpClient.put(`${url2}/${id}`, employee);
  }

  deleteEmployeeById(id: number): Observable<Object>{
    return this.httpClient.delete(`${url2}/${id}`);
  }
}
