import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { environment } from "src/environments/environments";

@Injectable({
    providedIn: 'root'
})

export class HttpService{

    ENV_DEV = environment.apiUrl;

    constructor( private httpClient: HttpClient){};

    getData( table: string ): Observable<any>
    {
        return this.httpClient.get(`${this.ENV_DEV}/dvdstore/${table}`, {responseType: "json"});
    }

    getById(table:string, id:number): Observable<any>
    {
        return this.httpClient.get(`${this.ENV_DEV}/dvdstore/${table}/${id}`, {responseType: "json"});
    }

    deleteById = (table:string, id:number) => {
        return this.httpClient.delete(`${this.ENV_DEV}/dvdstore/${table}/${id}`, {responseType: "json"});
    }

}