import { Component,OnInit } from '@angular/core';
import { Dvd } from '../../utils/model/dvd.interface';
import { GenreEnum } from '../../utils/enum/GenreEnum';
import { environment } from 'src/environments/environments';
import { User } from 'src/app/admin/utils/model/user.interface';
import { HttpService } from '../../services/http.service';
import { PanierCreateDTO } from '../../core/panier/panierCreateDTO.interface';

@Component({
  selector: 'app-dvdstore',
  templateUrl: './dvdstore.component.html',
  styleUrls: ['./dvdstore.component.scss']
})

export class DvdstoreComponent implements OnInit {
  ENV_DEV_IMG = environment.apiImg + '/';
  table: string = "dvds";
  dvds: Dvd[]= [];
  dvdToShow: Dvd[] | any = [];
  // @Input vers sidebar
  genreEnum = GenreEnum;
  genreEnumValues = Object.values(this.genreEnum);
  currentUser!: User;

  constructor( private httpService: HttpService ){}

  ngOnInit( ) {
    // get the token if any
    let anything: any = sessionStorage.getItem('currentUser');
    if(anything != null){
      this.currentUser = JSON.parse(anything);
    }
    this.getDvds(this.table);

  }

  onGenreClicked(genreClicked : {genre:string}){
    this.dvdToShow = this.dvds.filter((value) =>{
      return value.genre === genreClicked.genre ;
    })
  }

  onSearchClicked(searchClicked : {search:string}){
    this.dvdToShow = this.dvds.filter((value) =>{
      return value.name.toLowerCase() === searchClicked.search ;
    })
  }

  public getDvds(table:string){
    this.httpService.getData(table)
    .subscribe({
      next:(response: Dvd[])=> this.dvdToShow = response,
      error:(err:Error)=>(console.log("page home all dvds "+ err)),
      complete: ()=>console.table(this.dvdToShow)
    })
  }

  // onCreatePanier = ()=> {        
  //   this.httpService.createPanier("panier", this.panierDTO)
  //   .subscribe({
  //     next:(data)=>{ console.log(data);
  //     },
  //     error:(err : Error)=>{console.log("create error"+ err);
  //     }
  //   })
  // }



}



// this.dvdToShow = this.getAllDvds();


// getAllDvds = ()=>{
//   this.jwtAxiosService.get<any>(this.ENV_DEV + this.table)
//   .subscribe({
//     next:(data: Dvd[])=> this.dvds = data,
//     error:(err: Error )=> console.error(err),
//     complete:()=>{}
//   }
//   )
// }

    // mapping
    // await this.getAllDvds().map((value:DvdGetAllDTO)=>{
    //   const dvd:Dvd = {
    //     id:value.id,
    //     name: value.name,
    //     genre: value.genre,
    //     quantite: value.quantite,
    //     prix: value.prix,
    //     picture: value.picture
    //   }
    //   this.dvds.push(dvd);
    // })
   
    // this.dvdToShow = await dvdGetAllDTOs;