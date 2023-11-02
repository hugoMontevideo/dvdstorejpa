import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable,map } from "rxjs";
import { environment } from "src/environments/environments";
import { Router } from "@angular/router";
import { PanierCreateDTO } from "../core/panier/panierCreateDTO.interface";
import { PanierDvdInsertDTO1 } from "../core/panier/panierDvdInsertDTO1.interface";

@Injectable({
    providedIn: 'root'
})

export class HttpService{

    ENV_DEV = environment.apiUrl;

    // const url = 'votre_url_de_service'; // Remplacez par l'URL de votre service
    // const monParametre = 42; // Valeur numérique que vous souhaitez envoyer

    // Créez un objet HttpHeaders pour configurer l'en-tête HTTP


    // // Effectuez la requête HTTP en incluant les options d'en-tête
    // this.http.get(url, httpOptions).subscribe(data => {
    // // Gérez la réponse ici
    // });


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
            headers: new HttpHeaders({
                'Header-dvd-id': dvdId.toString(),
                'Header-dvd-quantite': dvdQuantite.toString()
            })
         };
        return this.httpClient.delete(`${this.ENV_DEV}/clients/${id}/panier/panierdvd/${idPanierdvd}`, httpOptions);
    }


    


}