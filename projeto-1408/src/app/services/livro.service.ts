import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'
import {Observable} from 'rxjs'
import { Livro } from '../models/livro.model';

@Injectable({
  providedIn: 'root'
})

export class LivroService {
  private url = 'http://localhost:8080/livro';
  
  constructor(private http:HttpClient) { }
  
  getLivro():Observable<Livro[]>{
    return this.http.get<Livro[]>(this.url);
  }

  getLivroById(id:number): Observable<Livro>{
    return this.http.get<Livro>(`${this.url}/${id}`);
  }


  deleteLivro(id:number):Observable<any>{
    return this.http.delete<any>(`${this.url}/${id}`);
  }

}