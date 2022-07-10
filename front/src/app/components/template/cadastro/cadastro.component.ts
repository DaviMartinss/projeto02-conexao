import { Component, OnInit } from '@angular/core';

import { User } from 'src/app/user';
import { UserService } from 'src/app/user.service';

@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.css']
})
export class CadastroComponent implements OnInit {

  users: User[] = [];
  
  constructor(private userService : UserService) { }
  

  ngOnInit(): void {
    this.getUsers();
  }

  getUsers(): void {
    this.userService.getUsers()
    .subscribe(users => this.users = users);
  }

  add(nome: string, email: string, genero: string, senha: string): void {
    nome = nome.trim();
    
    console.log("nome: "+nome + " email: "+email+ " gen: "+genero  +" senha" +senha);
    if (!nome) { return; }

    this.userService.addUser({ nome, email, genero, senha }  as User)
      .subscribe(user => {
        this.users.push(user);
      });
  }

}