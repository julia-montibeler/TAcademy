import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Appointment } from '../models/appointment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})

export class AppointmentService {

  private url = "http://localhost:8080/consultas";

  constructor(private httpClient: HttpClient) { }

  getAppointments() : Observable<Appointment[]> {
    return this.httpClient.get<Appointment[]>(this.url);
  }  
}
