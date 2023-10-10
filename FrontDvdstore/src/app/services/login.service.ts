import { HttpBackend, HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { LoginView } from "../login/model/login-view.interface";
import { Observable, map } from "rxjs";
import { environment } from "src/environments/environments";
import { LoginResponse } from "../register/model/login-response.interface";
import { JWTTokenService } from "./JWTTokens.service";
import { Router } from "@angular/router";

@Injectable({
    providedIn: 'root'
})

export class LoginService {
    ENV_LOG: string = `http://localhost`;
    table:string = "auth";

    currentUser: LoginResponse = {
                username: "",
                token: ""
            };

    httpClient!: HttpClient;  // De cette façon on evite l'interceptor

    constructor(
            private jwtService: JWTTokenService,
            private router: Router,
            private httpBackend: HttpBackend
         ){}

    public login( loginView : LoginView ): Observable<any> {
        this.httpClient = new HttpClient(this.httpBackend);
    
                
        return this.httpClient.post<any>(`${this.ENV_LOG}/${this.table}/authorize`, loginView, {responseType:"json"})
        .pipe(map(data=>{
            console.log(data);
            this.currentUser.username = data.user.login;
            this.currentUser.token = data.token;
            sessionStorage.setItem("currentUser", JSON.stringify(this.currentUser));
            return this.currentUser.username;    
            
        }));
    }

}



// this.jwtService.setToken(data.token);
// // vérifier validité token
// var decodeToken = this.jwtService.getDecodeToken();

// if(this.jwtService.getExpiryTime() > 0){
//     sessionStorage.setItem("currentUser", JSON.stringify(this.currentUser));  
//     return this.currentUser.username;    
// }else{
//     sessionStorage.removeItem("currentUser");
//     this.router.navigateByUrl("login");
//     return 
// }

// constructor(
    //         private jwtService: JWTTokenService,
    //         private router: Router,
    //         private httpClient: HttpClient
    //      ){}
         
    // public login( loginView : LoginView ): Observable<any> {