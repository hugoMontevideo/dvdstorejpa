import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ClientService } from 'src/app/admin/services/client.service';
import { HttpService } from 'src/app/admin/services/http.service';
import { Client } from 'src/app/admin/utils/model/client.interface';
import { environment } from 'src/environments/environments';
import { ClientGetAllDTO } from '../../services/interfaces/clientgetalldto.inteface';

@Component({
  selector: 'app-client-form',
  templateUrl: './client-form.component.html',
  styleUrls: ['./client-form.component.scss']
})
export class ClientFormComponent implements OnInit {
  legend: string = "Ajouter";
  table: string ="clients";
  ENV_DEV: string = environment.apiUrl;
  id!:number;
  currentClient: Client = {
    id:null,
    name:'',
    firstname:'',
    email:'',
    adresse: ''
  }
  genreEnumValues!: String[];    // liste de genre de dvd
  clientGetAllDTO!: ClientGetAllDTO;

  constructor(private clientService:ClientService,
    private route:ActivatedRoute,
    private httpService: HttpService){};

  ngOnInit(): void {
    this.id = Number(this.route.snapshot.paramMap.get('id'));
 
    if(this.id != 0){
      console.log(this.id)
      this.getClientById(this.table, this.id);
      this.legend="Modifier";
    }
  }

  getClientById=(table:string, id:number)=>{
    this.httpService.getById(table, id).subscribe({
      next:(response:Client)=> this.currentClient = response,
      error: (err: Error)=>console.error("Error getClientById"),
      complete: ()=>console.log(this.currentClient)
    })
  }

  onSubmit = () => {
    if(this.legend == "Ajouter"){  // Add ***
      this.clientService.addClient(this.currentClient);     
    }else{          //  Modify  ***

      this.clientGetAllDTO = {
        id: this.id,
        name: this.currentClient.name,
        firstname: this.currentClient.firstname,
        email: this.currentClient.email,
        adresse: this.currentClient.adresse
      }
      // console.log(this.clientGetAllDTO);
      this.clientService.updateClient(this.clientGetAllDTO);
    }
  } // onSubmit

}




