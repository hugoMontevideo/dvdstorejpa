import axios, { Axios } from 'axios';
import { DvdGetAllDTO } from './interfaces/dvdgetalldto.inteface';
import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root'
})

export class DvdService{

    constructor(){ }

    getAllDvd = async () => {
    
        return( await axios.get('http://localhost/dvdstore/dvds')).data ;
    }





}
