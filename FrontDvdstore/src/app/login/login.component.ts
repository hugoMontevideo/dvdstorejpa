import { Component } from '@angular/core';
import { LoginView } from './model/login-view.interface';
import { Router } from '@angular/router';
import { LoginService } from '../services/login.service';
import { User } from '../admin/utils/model/user.interface';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
  
  loginView: LoginView = {
        username: "",
        password:""
      };
  loginError: string = "";
  currentUser!:User;

  constructor( 
    private loginService: LoginService,
    private router: Router,

  ){};

  ngOnInit(): void {

    let anything: any = sessionStorage.getItem('currentUser');
    if(anything != null){
      sessionStorage.clear();
      this.router.navigateByUrl('/dvdstore');
    }
    
  }

  onLoginClick(){
    this.loginService.login(this.loginView)
    .subscribe({
      next:(data)=> this.router.navigateByUrl("/dvdstore") ,
      error: (err:Error)=> {
        console.error("Error");
        this.loginError="Mdp ou email invalides"
      },
      complete: ()=>console.log("login ok")      
    })
  }


}
