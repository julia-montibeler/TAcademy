import { Component, Injectable, OnInit} from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { MusicService } from './services/music.service';
import { NgFor, NgIf } from '@angular/common';
import { Tracks } from './models/tracks';
import { Album } from './models/album';
import { HeaderComponent } from "./components/header/header.component";
import { AlbumComponent } from "./components/album/album.component";
import { TrackComponent } from "./components/track/track.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, NgIf, NgFor, HeaderComponent, AlbumComponent, TrackComponent],
  providers: [MusicService],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})

@Injectable({ providedIn: 'root' })
export class AppComponent implements OnInit {
  title = 'fanpage';
  topTracks: Tracks[] = [];
  albums: Album[] = [];
  singles: Album[] = [];

  constructor(private musicService: MusicService) {}

  ngOnInit(): void {
    this.getTopTracks();
    this.getAlbums();
    this.getSingles();
  }
  
  getTopTracks() {
    this.musicService.getTopTracks().subscribe(
      (response) => {
        this.topTracks = response.tracks;
        console.log(this.topTracks);
      },
      (error) => {
        console.error('Erro ao obter as faixas', error);
      }
    );
  }

  getAlbums() {
    this.musicService.getAlbums().subscribe(
      (response) => {
        this.albums = response.items;
        console.log(this.albums);
      },
      (error) => {
        console.error('Erro ao obter os albums', error);
      }
    );
  }

  getSingles() {
    this.musicService.getSingles().subscribe(
      (response) => {
        this.singles = response.items;
        console.log(this.singles);
      },
      (error) => {
        console.error('Erro ao obter os singles', error);
      }
    );
  }
}