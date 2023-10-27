import { Component, OnInit } from '@angular/core';
import { GenreEnum } from 'src/app/admin/utils/enum/GenreEnum';
// import { JwtAxiosService } from 'src/app/services/JwtAxios.service';
import { environment } from 'src/environments/environments';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpService } from 'src/app/admin/services/http.service';
import { Dvd } from 'src/app/admin/utils/model/dvd.interface';


@Component({
  selector: 'app-dvd-form',
  templateUrl: './dvd-form.component.html',
  styleUrls: ['./dvd-form.component.scss']
})
export class DvdFormComponent implements OnInit{
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
      this.legend="Modifier";
    }
  }

  onFileSelected(event: any) {   
    this.selectedFile = event.target.files[0];
  }

  onSubmit() {
    
    const formData = new FormData();
      formData.append('name', this.currentDvd.name);
      formData.append('genre', this.currentDvd.genre);
      formData.append('quantite', this.currentDvd.quantite.toString());
      formData.append('prix', this.currentDvd.prix.toString() );

    if(this.legend ==  "Ajouter"){  // Add ***
      if (!this.selectedFile) {
        console.error("Aucun fichier sélectionné.");
        this.errorMsg = "Veuillez sélectionner un fichier."
        return;
      }

      formData.append('file', this.selectedFile);
      this.httpService.addDvd(formData)
      .subscribe({
        next:(response)=>console.log(response),
        error: (err: Error)=>console.error(`Error getDvdById ${err}`)
      });
      // this.jwtAxiosService.addDvd(formData);
    }else{            //  Modify    ***

      if(this.selectedFile){
        formData.append('file', this.selectedFile);
      }
      formData.append('picture', this.currentDvd.picture);
      this.httpService.updateDvd(formData, this.currentDvd.id??0)
      .subscribe({
        next:()=> this.router.navigateByUrl("/"),
        error: (err: Error)=>console.error(`Error putDvdById ${err.message}`)
      });
      // this.jwtAxiosService.updateDvd(formData, this.id );
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




