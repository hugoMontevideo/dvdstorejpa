import axios from 'axios';
import { Injectable } from '@angular/core';


@Injectable({
    providedIn: 'root'
})

export class DvdService{

    constructor(){ }

    getAllDvd = async () => {
    
        return( await axios.get('http://localhost/dvdstore/dvds')).data ;
    }

    // addDvd = async ( dvdFileDTO: DvdFileDTO ) => {
        
    //     console.log(dvdFileDTO);
        
    //     await axios.post('http://localhost/dvdstore/dvds', dvdFileDTO);
    // }

    addDvd = ( formData: FormData ) => {
        
        console.log(formData);
        axios.post('http://localhost/dvdstore/dvds/upload', formData)
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
