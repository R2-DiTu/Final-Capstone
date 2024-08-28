import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';
import { Login } from '../login';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{
  login:Array<Login>=[];
  constructor(public ls:LoginService){}  //DI

  ngOnInit(): void {
      this.ls.loadAllLoginInfo().subscribe({
      next:(result:any)=>{
          this.login=result;
      },
      error:(error:any)=> {
          console.log(error)
      },
      complete:()=> {
          console.log("Login details loaded")
      }
    })

  }

}
