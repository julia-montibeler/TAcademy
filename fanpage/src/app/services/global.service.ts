import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http'

@Injectable({
    providedIn: 'root'
  })

export class GlobalService {
    constructor (private http: HttpClient) {}

    getAccessToken(): string | null {
        const regex = /access_token=([^&]*)/;
        const queryString = window.location.hash;
        const match = regex.exec(queryString);
    
        return match ? decodeURIComponent(match[1]) : null;
    }
}