import { Component, OnInit } from '@angular/core';
import { LoginService } from '../../../login.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  username: string = '';
  password: string = '';

  constructor(private loginService: LoginService) { }

  ngOnInit(): void {
  }

  login(){
    console.log('login - ' + this.username + ':' + this.password);

    this.loginService.login(this.username, this.password)


  }

}
