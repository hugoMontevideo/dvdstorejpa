import axios from 'axios';
import { DvdGetAllDTO } from './interfaces/dvdgetalldto.inteface';
import { Injectable } from '@angular/core';
import { NgForm } from '@angular/forms';
import { DvdDTO } from './interfaces/dvdDTO.interface';

@Injectable({
    providedIn: 'root'
})

export class DvdService{

    constructor(){ }

    getAllDvd = async () => {
    
        return( await axios.get('http://localhost/dvdstore/dvds')).data ;
    }

    addDvd = async ( dvdDTO: DvdDTO ) => {
        await axios.post('http://localhost/dvdstore/dvds', dvdDTO);
    }





}
