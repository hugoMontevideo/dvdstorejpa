import { HttpErrorResponse, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable, catchError, throwError } from 'rxjs';

@Injectable()

export class JWTInterceptorService implements HttpInterceptor {

  constructor(
    private route: Router
  ) { }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    var currentUserToken="HelloToken";

    let anything: any = sessionStorage.getItem('currentUser');
    if(anything != null){
      currentUserToken = JSON.parse(anything).token;
    }

    req = req.clone({
      setHeaders:{
          Authorization: "Bearer " + currentUserToken
      }
    });
      return next.handle(req)
      .pipe(
        catchError((error:HttpErrorResponse)=>{
          const errorCode = error.status;

          console.log(errorCode);

          if(errorCode == 403){
            this.route.navigateByUrl("/login")
          }
          
          return throwError(()=>error);

        })
      );
  }


}
