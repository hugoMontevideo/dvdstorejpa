import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { GenreEnum } from 'src/app/utils/enum/GenreEnum';
import { DvdService } from 'src/app/services/dvd.service';
import { DvdFileDTO } from 'src/app/services/interfaces/dvdFileDTO.interface';
import { environment } from 'src/environments/environments';
import { ActivatedRoute } from '@angular/router';
import { HttpService } from 'src/app/services/http.service';
import { Dvd } from 'src/app/utils/models/dvd.interface';
import { DvdGetDTO } from 'src/app/services/interfaces/dvdGetDTO.interface';

@Component({
  selector: 'app-dvd-form',
  templateUrl: './dvd-form.component.html',
  styleUrls: ['./dvd-form.component.scss']
})
export class DvdFormComponent implements OnInit{
  legend: string = "Ajouter";
  table: string ="dvds";
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

  // dvdFileDTO!: DvdFileDTO;
  // dvdGetDTO!: DvdGetDTO;
  
  genreEnum = GenreEnum;
  genreEnumValues = Object.values(this.genreEnum);
  selectedFile!: File | null;

  constructor(private dvdService:DvdService,
              private route:ActivatedRoute,
              private httpService: HttpService){};

  ngOnInit(): void {
    this.id = Number(this.route.snapshot.paramMap.get('id'));
 
    if(this.id != 0){
      console.log(this.id)
      this.getDvdById(this.table, this.id);
      this.legend="Modifier";
    }
  }

  onFileSelected(event: any) {   
    this.selectedFile = event.target.files[0];
  }

  onSubmit() {
      // Vous pouvez maintenant envoyer this.selectedFile au serveur pour l'upload.
      // Vous pouvez utiliser une bibliothèque comme Axios ou HttpClient pour effectuer la requête POST.
      // Exemple simplifié :
    const formData = new FormData();
      formData.append('name', this.currentDvd.name);
      formData.append('genre', this.currentDvd.genre);
      formData.append('quantite',  this.currentDvd.quantite.toString()  ) ;
      formData.append('prix', this.currentDvd.prix.toString() );

    if(this.legend ==  "Ajouter"){
      if (!this.selectedFile) {
        console.error("Aucun fichier sélectionné.");
        return;
      }
      formData.append('file', this.selectedFile);
      this.dvdService.addDvd(formData);
    }else{  //  Modify    

      if(this.selectedFile){
        formData.append('file', this.selectedFile);
      }
      formData.append('picture', this.currentDvd.picture);
      this.dvdService.updateDvd(formData, this.id );
    }
  } // onSubmit

  public getDvdById(table:string, id:number){
    this.httpService.getById(table, id).subscribe({
      next:(response:Dvd)=> this.currentDvd = response,
      error: (err: Error)=>console.error("Error getDvdById"),
      complete: ()=>console.log(this.currentDvd)
    })

  }

    // onSubmit = ()=>{
  //   console.log(this.selectedFile);
    
  //   if(this.selectedFile){
  //     const formData = new FormData;
  //     formData.append('file', this.selectedFile)
  //     this.dvdService.addDvd(formData);


  //   }else{
  //     console.log('Erreur upload picture. Aucun fichier selectionné');
      
  //   }

  // }

}



