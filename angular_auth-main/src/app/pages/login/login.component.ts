import { Component, inject, NgModule } from '@angular/core';
import { Login } from '../../models/login';
import {FormsModule} from '@angular/forms'
import { AuthService } from '../../services/auth.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  login: Login = {
    login: "",
    password: ""
  }

  constructor(private authService:AuthService, private router: Router, private route: ActivatedRoute){}

  onLogin(){
    this.authService.login(this.login).subscribe({
      next: (res:any)=> {
          console.log(res)
          localStorage.setItem("token_angular", res.token)
          const route = this.route.snapshot.queryParamMap.get('stateUrl') || ''
          this.router.navigateByUrl(route)  
      },
      error: () => alert("Senha ou usuário inválidos")
    })
  }

}
