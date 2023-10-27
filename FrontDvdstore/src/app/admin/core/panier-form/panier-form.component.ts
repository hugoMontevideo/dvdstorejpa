import { Component,OnInit } from '@angular/core';
import { environment } from 'src/environments/environments';
import { Dvd } from '../../utils/model/dvd.interface';
import { GenreEnum } from '../../utils/enum/GenreEnum';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpService } from '../../services/http.service';
import { PanierDvdInsertDTO } from '../panier/panierDvdInsertDTO.interface';
import { PanierDTO } from '../panier/panierDTO.interface';

@Component({
  selector: 'app-panier-form',
  templateUrl: './panier-form.component.html',
  styleUrls: ['./panier-form.component.scss']
})

export class PanierFormComponent  implements OnInit{
  legend: string = "Ajouter";
  table: string ="dvds";
  errorMsg: string = "";
  ENV_DEV: string = environment.apiUrl;
  id!:number;
  currentDvd: Dvd = {
    id:null,
    name:'',
    genre:'',
    quantite:0,
    prix:0,
    picture: '',
  }


  panierInsertDTO : PanierDvdInsertDTO = {
                      dvdId: 0,
                      panierId: 0,
                      dvdSubtotal: 0,
                      clientId: 0,
                      dvdQuantite: 0,
                      dvdPrix: 0
                  }

  client_id: number = 2; // à automatiser  (? @output)

  // dvdFileDTO!: DvdFileDTO;
  // dvdGetDTO!: DvdGetDTO;
  
  genreEnum = GenreEnum;
  genreEnumValues = Object.values(this.genreEnum);
  selectedFile!: File | null;

  constructor(
              private route:ActivatedRoute,
              private httpService: HttpService,
              private router: Router
            ){};

  ngOnInit(): void {
    this.id = Number(this.route.snapshot.paramMap.get('id'));
    if(this.id != 0){
      this.getDvdById(this.table, this.id);
      this.legend="Ajouter";
    }
  }

  onSubmit() {
    this.panierInsertDTO.dvdId = this.currentDvd.id!;
    this.panierInsertDTO.panierId = this.currentDvd.id!;
    this.panierInsertDTO.dvdId = this.currentDvd.id!;
    this.panierInsertDTO.dvdId = this.currentDvd.id!;
    this.panierInsertDTO.dvdId = this.currentDvd.id!;
    
    // const formData = new FormData();
    //   formData.append('name', this.currentDvd.name);
    //   formData.append('genre', this.currentDvd.genre);
    //   formData.append('quantite', this.currentDvd.quantite.toString());
    //   formData.append('prix', this.currentDvd.prix.toString() );

    if(this.legend ==  "Ajouter"){  // Add ***

      // this.httpService.addDvd(this.panierInsertDTO)
      // .subscribe({
      //   next:(response)=>console.log(response),
      //   error: (err: Error)=>console.error(`Error getDvdById ${err}`)
      // });
    }

  } // onSubmit


  public getDvdById(table:string, id:number){
    this.httpService.getById(table, id).subscribe({
      next:(response:Dvd)=> this.currentDvd = response,
      error: (err: Error)=>console.error("Error getDvdById"),
      complete: ()=>console.log(this.currentDvd)
    })
  }
}





