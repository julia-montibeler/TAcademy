import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Livro } from './models/livro.model';
import { LivroService } from './services/livro.service';
import { LivroComponent } from './components/livro/livro.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, CommonModule, LivroComponent],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  livros: Livro[] = [];

  constructor(private livroService: LivroService) {}
0
  ngOnInit(): void {
    this.getLivros();
  }

  getLivros(): void {
    console.log("oi");
    this.livroService.getLivro().subscribe(
      (response) => {
        this.livros = response;
      },
      (error) => {
        console.error('Erro ao carregar os dados: ', error);
      }
    );
  }
}
