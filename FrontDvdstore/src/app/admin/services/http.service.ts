import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable,map } from "rxjs";
import { environment } from "src/environments/environments";
import { Router } from "@angular/router";

@Injectable({
    providedIn: 'root'
})

export class HttpService{

    ENV_DEV = environment.apiUrl;

    constructor( 
        private httpClient: HttpClient,
        private router: Router
    ){};

    getData( table: string ): Observable<any>
    {
        return this.httpClient.get(`${this.ENV_DEV}/dvdstore/${table}`, {responseType: "json"});
    }

    getById = (table:string, id:number): Observable<any> => {
        return this.httpClient.get(`${this.ENV_DEV}/dvdstore/${table}/${id}`, {responseType: "json"});
    }

    deleteById = (table:string, id:number) => {
        return this.httpClient.delete(`${this.ENV_DEV}/dvdstore/${table}/${id}`, {responseType: "json"});
    }

    addDvd = (formData: FormData) => {
        return this.httpClient.post(`${this.ENV_DEV}/dvdstore/dvds`, formData, {responseType: "json"});
    }

    updateDvd =  (formData: FormData, id: number) => {

        return this.httpClient.put(`${this.ENV_DEV}/dvdstore/dvds/${id}`, formData, {responseType: "json"})
        .pipe(map(data=>{
            console.log("hello map");
            this.router.navigateByUrl("/dvdstore");
            return data;    
            
        }));
    }

    // PANIER API  ********
    getPaniers = ( table: string ): Observable<any> =>{
        return this.httpClient.get(`${this.ENV_DEV}/carts/${table}`, {responseType: "json"});
    }


    deletePanierDvd = ( table: string, id: number ): Observable<any> =>{
        return this.httpClient.delete(`${this.ENV_DEV}/carts/${table}/${id}`, {responseType: "json"});
    }


}