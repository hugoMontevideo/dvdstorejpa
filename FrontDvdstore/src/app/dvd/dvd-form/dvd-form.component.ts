import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { DvdDTO } from '../../services/interfaces/dvdDTO.interface';
import { GenreEnum } from 'src/app/utils/enum/GenreEnum';
import { DvdService } from 'src/app/services/dvd.service';
import { DvdFileDTO } from 'src/app/services/interfaces/dvdFileDTO.interface';
import { environment } from 'src/environments/environments';

@Component({
  selector: 'app-dvd-form',
  templateUrl: './dvd-form.component.html',
  styleUrls: ['./dvd-form.component.scss']
})
export class DvdFormComponent implements OnInit{
  legend: string = "Ajouter un dvd";
  ENV_DEV: string = environment.apiUrl;

  // dvdDTO: DvdDTO = {
  //   name:'',
  //   genre:'',
  //   quantite:0,
  //   prix:0,
  //   picture:'',
  // }
  dvdFileDTO: DvdFileDTO = {
    name:'',
    genre:'',
    quantite:0,
    prix:0,
    picture: null,
  }

  selectedFile: File | null = null;
  
  genreEnum = GenreEnum;
  genreEnumValues = Object.values(this.genreEnum);

  constructor(private dvdService:DvdService){};

  ngOnInit(): void {
  }
  onFileSelected(event: any) {   
    this.dvdFileDTO.picture = event.target.files[0];
  }

  onSubmit() {
     console.log(this.dvdFileDTO.picture);
    if (!this.dvdFileDTO.picture) {
      console.error("Aucun fichier sélectionné.");
      return;
    }
    // Vous pouvez maintenant envoyer this.selectedFile au serveur pour l'upload.
    // Vous pouvez utiliser une bibliothèque comme Axios ou HttpClient pour effectuer la requête POST.
    // Exemple simplifié :
    const formData = new FormData();
    formData.append('name', this.dvdFileDTO.name);
    formData.append('genre', this.dvdFileDTO.genre);
    formData.append('quantite',  this.dvdFileDTO.quantite.toString()  ) ;
    formData.append('prix', this.dvdFileDTO.prix.toString() );

    formData.append('file', this.dvdFileDTO.picture);
    
    this.dvdService.addDvd(formData);
   
    
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



