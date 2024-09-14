import { Component, Input } from '@angular/core';
import { Appointment } from '../../models/appointment';
import { CardModule } from 'primeng/card';

@Component({
  selector: 'app-appointment-card',
  standalone: true,
  imports: [CardModule],
  templateUrl: './appointment-card.component.html',
  styleUrl: './appointment-card.component.css'
})
export class AppointmentCardComponent {

  @Input() appointment: Appointment = 
    {
      id: '',
      medico: '',
      paciente: '',
      data: '',
    }

}
