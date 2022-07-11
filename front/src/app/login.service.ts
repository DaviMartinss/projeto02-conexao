import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';
import { Injectable } from '@angular/core';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})

export class LoginService {

  private API_USER_ME: string = 'http://localhost:8080/usuarios/';

  constructor(private http: HttpClient) { }

  login(username: string, password: string) {
      const url = `${this.API_USER_ME}/${username}&&${password}`;

       if(this.http.get<User>(url) != undefined )
       {
         console.log("LOGAR");
       }
       else
       {
         console.log("ERRO CREDENCIAIS");
       }

    }
}
