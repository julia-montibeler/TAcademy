import { Component, OnInit } from '@angular/core';
import { AppointmentService } from '../../services/appointment.service';
import { Appointment } from '../../models/appointment';
import { CommonModule } from '@angular/common';
import { ButtonModule } from 'primeng/button';
import { AppointmentCardComponent } from "../../components/appointment-card/appointment-card.component";
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-appointment-page',
  standalone: true,
  imports: [CommonModule, AppointmentCardComponent, ButtonModule],
  templateUrl: './appointment-page.component.html',
  styleUrl: './appointment-page.component.css'
})
export class AppointmentPageComponent implements OnInit{

  appointments: Appointment[] = [];

  constructor(private appointmentService: AppointmentService, private authService: AuthService) {}

  ngOnInit(): void {
    this.getAppointments();
  }

  getAppointments() {
    this.appointmentService.getAppointments().subscribe(
      (response) => {
        this.appointments = response;
      },
      (error) => {
        console.error('Error', error);
      }
    );
  }

  onLogout() {
    
  }

}
