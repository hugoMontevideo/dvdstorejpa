import axios from 'axios';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environments';
import { Router } from '@angular/router';
import { Client } from '../utils/models/client.interface';
import { ClientGetAllDTO } from './interfaces/clientgetalldto.inteface';


@Injectable({
    providedIn: 'root'
})

export class ClientService{
    ENV_DEV: string = environment.apiUrl;

    constructor(private router: Router){ }

    getAllClient = async () => {
    
        return( await axios.get(`${this.ENV_DEV}/clients`)).data ;
    }

    // addDvd = async ( dvdFileDTO: DvdFileDTO ) => {
        
    //     console.log(dvdFileDTO);
        
    //     await axios.post('http://localhost/dvdstore/dvds', dvdFileDTO);
    // }

    addClient = ( client: Client ) => {
        axios.post(`${this.ENV_DEV}/clients`, client)
        .then(response => {
            this.router.navigateByUrl("clients");
        })
       
    }

    updateClient = ( client: ClientGetAllDTO )=>{
         axios.put(`${this.ENV_DEV}/clients/${client.id}`, client)
         .then(response => {
            this.router.navigateByUrl("clients");
        })
    }



}
