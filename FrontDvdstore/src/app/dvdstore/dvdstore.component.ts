import { Component } from '@angular/core';
// import { HttpService } from '../services/http.service';
import { DvdService } from '../services/dvd.service';
import { Dvd } from '../models/dvd.interface';
import { DvdGetAllDTO } from '../services/interfaces/dvdgetalldto.inteface';

@Component({
  selector: 'app-dvdstore',
  templateUrl: './dvdstore.component.html',
  styleUrls: ['./dvdstore.component.scss']
})
export class DvdstoreComponent {
  path: string = "dvds";
  dvds: any[]= [];
  dvdToShow: any[] = [];

  constructor(
      // private httpService: HttpService,
      private dvdService : DvdService
      ){}

  async ngOnInit() {
    // this.getDvds(this.path);
    console.log('hello');
    
   const dvdGetAllDTOs = await this.dvdService.getAllDvd();

   dvdGetAllDTOs.map((value:DvdGetAllDTO)=>{
      const dvd:Dvd = {
        id:0,
        name: value.name,
        genre: value.genre,
        quantite: value.quantite,
        prix: value.prix,
        picture: value.picture
      }
      this.dvds.push(dvd);
    })
   
    this.dvdToShow = this.dvds;

  }


  // public getDvds(path:string){
  //   this.httpService.getData(path).subscribe({
  //     next:(response)=> this.dvds = response,
  //     error:(err:Error)=>(console.log("page home all dvds "+ err)),
  //     complete: ()=>console.log("all dvds ok")
  //   })
  // }





}
