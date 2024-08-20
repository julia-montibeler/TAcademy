import { Component, Input } from '@angular/core';
import { Tracks } from '../../models/tracks';

@Component({
  selector: 'app-track',
  standalone: true,
  imports: [],
  templateUrl: './track.component.html',
  styleUrl: './track.component.css'
})
export class TrackComponent {
  @Input() pos = 0;
  @Input() track: Tracks = {
    name: '',
    album: {
      name: '',
      images: []
    }
  }
}
