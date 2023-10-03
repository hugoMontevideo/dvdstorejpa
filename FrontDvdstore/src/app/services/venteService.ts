import axios from 'axios';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environments';
import { Router } from '@angular/router';
import { VenteGetAllDTO } from './interfaces/ventegetalldto.inteface';
import { NgForm } from '@angular/forms';


@Injectable({
    providedIn: 'root'
})

export class VenteService{
    ENV_DEV: string = environment.apiUrl;

    constructor(private router: Router){ }

    getAllVente = async () => {
        return( await axios.get(`${this.ENV_DEV}/ventes`))
        .data ;
    }

    addVente = ( data: JSON ) => {
        axios.post(`${this.ENV_DEV}/ventes`, data)
        .then(response => {
            this.router.navigateByUrl("ventes");
        }) 
    }

    updateClient = ( vente: VenteGetAllDTO )=>{
         axios.put(`${this.ENV_DEV}/ventes`, vente)
         .then(response => {
            this.router.navigateByUrl("ventes");
        })
    }



}
