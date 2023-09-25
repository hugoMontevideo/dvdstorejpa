import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";

@Injectable({
    providedIn: 'root'
})

export class HttpService{

    constructor( private http: HttpClient){};

    getData( table: string ): Observable<any>
    {
        return this.http.get(`http://localhost/dvdstore/${table}`, {responseType: "json"});
    }

    getById(path:string, id:number): Observable<any>
    {
        return this.http.get(`http://localhost/dvdstore/${path}/${id}`, {responseType: "json"});
    }

}