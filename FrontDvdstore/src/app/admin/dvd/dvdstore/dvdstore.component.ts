import { Component,OnInit } from '@angular/core';
import { Dvd } from '../../utils/model/dvd.interface';
import { GenreEnum } from '../../utils/enum/GenreEnum';
import { environment } from 'src/environments/environments';
import { User } from 'src/app/admin/utils/model/user.interface';
import { HttpService } from '../../services/http.service';
import { SharedService } from 'src/app/services/shared.service';
import { Observable } from 'rxjs';


@Component({
  selector: 'app-dvdstore',
  templateUrl: './dvdstore.component.html',
  styleUrls: ['./dvdstore.component.scss']
})

export class DvdstoreComponent implements OnInit {
  skipIon: boolean = true; // false during tests
  platform!: string;
  ENV_DEV_IMG = environment.apiImg + '/';
  table: string = "dvds";
  dvds: Dvd[] | any = [];
  dvdToShow: Dvd[] | any = [];
  // @Input vers sidebar
  genreEnum = GenreEnum;
  genreEnumValues = Object.values(this.genreEnum);
  currentUser!: User;
  currentHeight:any;

  constructor( 
      private httpService: HttpService,
      public sharedService: SharedService
    ){}

  ngOnInit( ) {
    this.platform = this.sharedService.platform;
    // get the token if any
    let anything: any = sessionStorage.getItem('currentUser');
    if(anything != null){
      this.currentUser = JSON.parse(anything);
    }

    this.getDvds();
  }

  onGenreClicked(genreClicked : {genre:string}){
    this.dvdToShow = this.dvds.filter((value:any) =>{
      return value.genre === genreClicked.genre ;
    })
  }

  onSearchClicked(searchClicked : {search:string}){
    this.dvdToShow = this.dvds.filter((value:any) =>{
      return value.name.toLowerCase() === searchClicked.search ;
    })
  }

  public getDvds(){
    this.httpService.getData1(this.table)
    .subscribe({
      next:(response: Dvd[])=> this.dvdToShow = response,
      error:(err:Error)=>(console.log("page home all dvds "+ err)),
      complete: ()=>console.table(this.dvdToShow)
    })
  }

  generateTUToken = (user: string, secret : string) => {
    this.httpService.generateTUToken(user, secret);
  }

  public getDvdsTest(): Dvd[] | any{
    this.httpService.getDataTest(this.table)
    .subscribe({
      next:(response: Dvd[])=>{
        console.log(response);        
        this.dvdToShow = response;
      } ,
      error:(err:Error)=>(console.log("page home all dvds "+ err)),
      complete: ()=>console.table()
    })
  }


  public maFonction() {
    return "Hello World!";
  }




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