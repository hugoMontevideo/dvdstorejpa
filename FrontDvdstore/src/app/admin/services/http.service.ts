import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable,catchError,map, throwError } from "rxjs";
import { environment } from "src/environments/environments";
import { Router } from "@angular/router";
import { PanierCreateDTO } from "../core/panier/panierCreateDTO.interface";
import { PanierDvdInsertDTO1 } from "../core/panier/panierDvdInsertDTO1.interface";
import { VenteAddDTO } from "./interfaces/venteAddDTO.interface";
import { Dvd } from "../utils/model/dvd.interface";


@Injectable({
    providedIn: 'root'
})

export class HttpService{

    ENV_DEV = environment.apiUrl;

    constructor( 
        private httpClient: HttpClient,
        private router: Router
    ){};

    addVente=(venteDTO: VenteAddDTO)=>{  // ***** faire appel feign client
        return this.httpClient.post(`${this.ENV_DEV}/clients/${venteDTO.clientId}/purchase`, venteDTO, {responseType: "json"}) 
    }

    
    getData1( table: string ): Observable<any>
    {
        return this.httpClient.get(`${this.ENV_DEV}/${table}`, {responseType: "json"});
    }

    getById = (table:string, id:number): Observable< Dvd | any > => {
        return this.httpClient.get(`${this.ENV_DEV}/dvdstore/${table}/${id}`, {responseType: "json"});
    }

    getById1 = (table:string, id:number): Observable<any> => {
        return this.httpClient.get(`${this.ENV_DEV}/${table}/${id}`, {responseType: "json"});
    }

    deleteById = (table:string, id:number) => {
        return this.httpClient.delete(`${this.ENV_DEV}/dvdstore/${table}/${id}`, {responseType: "json"});
    }
    deleteById1 = (table:string, id:number) => {
        return this.httpClient.delete(`${this.ENV_DEV}/${table}/${id}`, {responseType: "json"});
    }

    addDvd = (formData: FormData) => {
        return this.httpClient.post(`${this.ENV_DEV}/dvdstore/dvds`, formData, {responseType: "json"});
    }
    addDvd1 = (formData: FormData) => {
        return this.httpClient.post(`${this.ENV_DEV}/dvds`, formData, {responseType: "json"});
    }

    updateDvd =  (formData: FormData, id: number) => {

        return this.httpClient.put(`${this.ENV_DEV}/dvdstore/dvds/${id}`, formData, {responseType: "json"})
        .pipe(map(data=>{
            this.router.navigateByUrl("/");
            return data;    
            
        }));
    }
    updateDvd1 =  (formData: FormData, id: number) => {

        return this.httpClient.put(`${this.ENV_DEV}/dvds/${id}`, formData, {responseType: "json"})
        .pipe(map(data=>{
            this.router.navigateByUrl("/");
            return data;    
            
        }));
    }

    // PANIER API  ********
     // panier
    getPaniers = ( table: string ): Observable<any> =>{
        return this.httpClient.get(`${this.ENV_DEV}/carts/${table}`, {responseType: "json"});
    }

    getPanierByClientId = ( id: number, panierId: number):Observable<any> => {
        return this.httpClient.get(`${this.ENV_DEV}/clients/${id}/panier/${panierId}`, {responseType: "json"}) 
    }

   
    createPanier = ( table: string, panierDTO : PanierCreateDTO): Observable<any> =>{
        return this.httpClient.post(`http://localhost/carts/panier`, panierDTO, {responseType: "json"});
    }

      // panierdvd
    addPanierDvd = ( panierDvd : PanierDvdInsertDTO1) => {
        return this.httpClient.post(`http://localhost/clients/${panierDvd.clientId}/panier/panierdvd`, panierDvd, {responseType: "json"});

    }
    deletePanierDvd = ( id: number, idPanierdvd: number, dvdId:number, dvdQuantite : number ): Observable<any> =>{
        let httpOptions = {
            // envoie des parametres dans le header
            headers: new HttpHeaders({
                'Header-dvd-id': dvdId.toString(),
                'Header-dvd-quantite': dvdQuantite.toString()
            })
         };
        return this.httpClient.delete(`${this.ENV_DEV}/clients/${id}/panier/panierdvd/${idPanierdvd}`, httpOptions);
    }
    
    // TESTS UNITAIRES  ********
    generateTUToken = ( user: string, secret: string) => {
        let iat = new Date().getTime();
        let exp = iat + 3600 * 1000;
        const header = btoa(JSON.stringify({ "alg":"HS512" }));
        const payload = btoa(JSON.stringify({
                    "sub":user,
                    "iat":iat,
                    "exp":exp
                }));
        const signature = btoa(header+payload+secret);
        let dirtyToken = `${header}.${payload}.${signature}`;
        //nettoyage des caracteress non valides
        let token = dirtyToken.replace(/[^a-zA-Z0-9.]/g,'');
        // console.log(token);
        return token; 
    }
    

    getDataTest( table: string ): Observable<Dvd[]|any>
    {
        let token  = this.generateTUToken('eric', 'maCle');
        let httpOptions = {
            // ajout du token dans headers
            headers: new HttpHeaders({
                'Authorization': `Bearer ${token}`
            })
         };

        return this.httpClient.get(`${this.ENV_DEV}/${table}`, httpOptions );
    }

    
    getByIdTest = (table:string, id:number): Observable<Dvd | any> => {
        let token  = this.generateTUToken('eric', 'maCle');
        let httpOptions = {
            // ajout du token dans headers
            headers: new HttpHeaders({
                'Authorization': `Bearer ${token}`
            })
         };
        
        return this.httpClient.get(`${this.ENV_DEV}/${table}/${id}`, httpOptions);
    }

    
    
    
    
}

// const url = 'votre_url_de_service'; // Remplacez par l'URL de votre service
// const monParametre = 42; // Valeur numérique que vous souhaitez envoyer

// Créez un objet HttpHeaders pour configurer l'en-tête HTTP


// // Effectuez la requête HTTP en incluant les options d'en-tête
// this.http.get(url, httpOptions).subscribe(data => {
// // Gérez la réponse ici
// });