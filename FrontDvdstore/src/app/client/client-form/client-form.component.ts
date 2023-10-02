import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ClientService } from 'src/app/services/client.service';
import { HttpService } from 'src/app/services/http.service';
import { Client } from 'src/app/utils/models/client.interface';
import { environment } from 'src/environments/environments';

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
  genreEnumValues!: String[]; // liste de genre de dvd

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
      error: (err: Error)=>console.error("Error getDvdById"),
      complete: ()=>console.log(this.currentClient)
    })
  }

  onSubmit = () => {
      this.clientService.addClient(this.currentClient);     
  } // onSubmit

}




