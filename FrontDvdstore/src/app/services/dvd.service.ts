import axios from 'axios';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environments';


@Injectable({
    providedIn: 'root'
})

export class DvdService{
    ENV_DEV: string = environment.apiUrl;

    constructor(){ }

    getAllDvd = async () => {
    
        return( await axios.get(`${this.ENV_DEV}/dvds`)).data ;
    }

    // addDvd = async ( dvdFileDTO: DvdFileDTO ) => {
        
    //     console.log(dvdFileDTO);
        
    //     await axios.post('http://localhost/dvdstore/dvds', dvdFileDTO);
    // }

    addDvd = ( formData: FormData ) => {
        
        console.log(formData);
        axios.post('http://localhost/dvdstore/dvds', formData)
        // .then((response)=> {
        //     console.log("succes ", response.data);
        //     return "ok";
        // })
        // .catch((error)=>{
        //     console.log("error", error);
        //     return "error";
        // })

    }



}
