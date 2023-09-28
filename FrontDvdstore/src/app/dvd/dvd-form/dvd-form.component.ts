import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { DvdDTO } from '../../services/interfaces/dvdDTO.interface';
import { GenreEnum } from 'src/app/utils/enum/GenreEnum';
import { DvdService } from 'src/app/services/dvd.service';
import { DvdFileDTO } from 'src/app/services/interfaces/dvdFileDTO.interface';

@Component({
  selector: 'app-dvd-form',
  templateUrl: './dvd-form.component.html',
  styleUrls: ['./dvd-form.component.scss']
})
export class DvdFormComponent implements OnInit{
  legend: string = "Ajouter un dvd";

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


  onFileSelected(event: any) {   
    this.selectedFile = event.target.files[0];
  }

  onSubmit() {
     console.log(this.selectedFile);
    if (!this.selectedFile) {
      console.error("Aucun fichier sélectionné.");
      return;
    }

    // Vous pouvez maintenant envoyer this.selectedFile au serveur pour l'upload.
    // Vous pouvez utiliser une bibliothèque comme Axios ou HttpClient pour effectuer la requête POST.
    // Exemple simplifié :
    const formData = new FormData();
    formData.append('file', this.selectedFile);
    this.dvdService.addDvd(formData);

    // Envoyez formData au serveur en utilisant Axios ou HttpClient.
    // axios.post('URL_DU_ENDPOINT_API', formData).then(response => {
    //   console.log('Image téléchargée avec succès', response);
    // }).catch(error => {
    //   console.error('Erreur lors de l\'upload de l\'image', error);
    // });
  }
}



