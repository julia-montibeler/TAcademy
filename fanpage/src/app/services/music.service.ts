import { Injectable } from '@angular/core';
import { GlobalService } from './global.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Tracks } from '../models/tracks';
import { Album } from '../models/album';
import { ArtistAlbumsResponse } from '../models/artist-albums-response';

@Injectable({
  providedIn: 'root'
})
export class MusicService {

  private readonly baseUrl: string = 'https://api.spotify.com/v1/artists/63yrD80RY3RNEM2YDpUpO8';
  
  constructor(private http: HttpClient, private globalService: GlobalService) { }

  private getHeaders(): HttpHeaders {
    return new HttpHeaders({
      'Authorization': `Bearer ${this.globalService.getAccessToken()}`
    });
  }

  getTopTracks(): Observable<{ tracks: Tracks[] }> {
    const url: string = `${this.baseUrl}/top-tracks?country=BR`;
    return this.http.get<{ tracks: Tracks[] }>(url, { headers: this.getHeaders() });
  }

  getAlbums(): Observable<ArtistAlbumsResponse> {
    const url: string = `${this.baseUrl}/albums?offset=0&limit=30&include_groups=album`;
    return this.http.get<ArtistAlbumsResponse>(url, { headers: this.getHeaders() });
  }

  getSingles(): Observable<ArtistAlbumsResponse> {
    const url: string = `${this.baseUrl}/albums?offset=0&limit=30&include_groups=single`;
    return this.http.get<ArtistAlbumsResponse>(url, { headers: this.getHeaders() });
  }
}