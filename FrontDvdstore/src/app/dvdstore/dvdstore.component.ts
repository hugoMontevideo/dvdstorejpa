import { Component,OnInit } from '@angular/core';
// import { HttpService } from '../services/http.service';
import { DvdService } from '../services/dvd.service';
import { Dvd } from '../models/dvd.interface';
import { DvdGetAllDTO } from '../services/interfaces/dvdgetalldto.inteface';
import { GenreEnum } from '../utils/enum/GenreEnum';

@Component({
  selector: 'app-dvdstore',
  templateUrl: './dvdstore.component.html',
  styleUrls: ['./dvdstore.component.scss']
})

export class DvdstoreComponent implements OnInit  {
  path: string = "dvds";
  dvds: Dvd[]= [];
  dvdToShow: Dvd[] = [];
  // @Input vers sidebar
  genreEnum = GenreEnum;
  genreEnumValues = Object.values(this.genreEnum);

  constructor(
      // private httpService: HttpService,
      private dvdService : DvdService
      ){}

  async ngOnInit() {
    
   const dvdGetAllDTOs = await this.dvdService.getAllDvd();

   dvdGetAllDTOs.map((value:DvdGetAllDTO)=>{
      const dvd:Dvd = {
        id:value.id,
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

  onGenreClicked(genreClicked : {genre:string}){
    this.dvdToShow = this.dvds.filter((value) =>{
      return value.genre === genreClicked.genre ;
    })

    console.log(genreClicked.genre);
    
  }

  onSearchClicked(searchClicked : {search:string}){
    this.dvdToShow = this.dvds.filter((value) =>{
      return value.name.toLowerCase() === searchClicked.search ;
    })
    
  }
  // public getDvds(path:string){
  //   this.httpService.getData(path).subscribe({
  //     next:(response)=> this.dvds = response,
  //     error:(err:Error)=>(console.log("page home all dvds "+ err)),
  //     complete: ()=>console.log("all dvds ok")
  //   })
  // }

}
