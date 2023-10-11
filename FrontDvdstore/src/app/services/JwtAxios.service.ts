import axios, {AxiosInstance, AxiosRequestConfig, AxiosResponse, InternalAxiosRequestConfig} from 'axios';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environments';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';


@Injectable({
    providedIn: 'root'
})

export class JwtAxiosService {

    ENV_DEV: string = environment.apiUrl; // url de l'api
    private axiosInstance: AxiosInstance;
   
    constructor(private router: Router){ 
        this.axiosInstance = axios.create({
            // Config axios (baseUrl, timeout, headers)
            baseURL: environment.apiUrl,
            timeout:10000,

        });

        this.setupInterceptors();
    }

    private setupInterceptors(){

        this.axiosInstance.interceptors.request.use(
            (config: InternalAxiosRequestConfig)=> {
                var currentUserToken="HelloToken";

                let anything: any = sessionStorage.getItem('currentUser');
                if(anything != null){
                    currentUserToken = JSON.parse(anything).token;
                }
                config.headers['Authorization'] = `Bearer ${currentUserToken}`;
               
                return config;
            },
            (error)=> {
                return Promise.reject(error);
             }
        );

        this.axiosInstance.interceptors.response.use(
            (response: AxiosResponse) => {
              // Vous pouvez traiter la réponse ici
              return response;
            },
            (error) => {
              return Promise.reject(error);
            }
          );
    }

    getAllDvd = async (table:string) => {
    
        return( await axios.get(`${this.ENV_DEV}/${table}`)).data ;
    }

    // getAllDvd avec headers
    get<T>(url: string, config?: InternalAxiosRequestConfig): Observable<T>{
        return new Observable<any>((observer)=>{
            this.axiosInstance.get(url, config)
                .then((response)=> {
                    observer.next(console.log(
                     response.data));      
                    observer.complete();
                })
                .catch((error)=>{
                    observer.error(error);
                })
        });
        
    }

    // addDvd = async ( dvdFileDTO: DvdFileDTO ) => {
        
    //     console.log(dvdFileDTO);
        
    //     await axios.post('http://localhost/dvdstore/dvds', dvdFileDTO);
    // }

    addDvd = ( formData: FormData ) => {
        axios.post(`${this.ENV_DEV}/dvds`, formData)
        .then(response => {
            this.router.navigateByUrl("dvdstore");
        })
       
    }

    updateDvd = (formData: FormData, id:number)=>{
         axios.put(`http://localhost/dvdstore/dvds/${id}`, formData)  
         .then(response => {
            this.router.navigateByUrl("dvdstore");
        })
    }



}
