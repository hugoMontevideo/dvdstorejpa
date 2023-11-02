import { Component, OnInit } from '@angular/core';
import { LoginView } from './model/login-view.interface';
import { Router } from '@angular/router';
import { LoginService } from '../services/login.service';
import { User } from '../admin/utils/model/user.interface';
import { PanierCreateDTO } from '../admin/core/panier/panierCreateDTO.interface';

@Component({
  selector: 'app-login',
  templateUrl: './login.page.html',
  styleUrls: ['./login.page.scss']
})
export class LoginPage implements OnInit{
  
  loginView: LoginView = {
        username: "",
        password:""
      };
  loginError: string = "";
  currentUser!:User;
  panierDTO: PanierCreateDTO = {
    amount:0,
    clientId: 4,
    createdAt:0
  }

  constructor( 
    private loginService: LoginService,
    private router: Router,

  ){};

  ngOnInit(): void {

    let anything: any = sessionStorage.getItem('currentUser');
    if(anything != null){     // logout
      sessionStorage.clear();
      this.router.navigateByUrl('/login');
    } else{
      //this.panierDTO = anything.id;  // todo create panier
      // this.onCreatePanier();
    }   
  }

  onLoginClick(){
    this.loginService.login(this.loginView)
    .subscribe({
      next:(data)=> { 
        console.log(data);
              
            this.router.navigateByUrl("/");
          },
      error: (err:Error)=> {
        console.error("Error");
        this.loginError="Mdp ou email invalides";
      },
      complete: ()=>{
        console.log("login ok");
      }     
    })
  }

  onCreatePanier = ()=> {        
    this.loginService.createPanier("panier", this.panierDTO)
    .subscribe({
      next:(data)=>{ console.log(data);
      },
      error:(err : Error)=>{console.log("create error"+ err);
      }
    })
  }


}
