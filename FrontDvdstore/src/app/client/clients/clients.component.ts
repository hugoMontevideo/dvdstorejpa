import { Component, OnInit } from '@angular/core';
import { Client } from '../../utils/models/client.interface';
import { ClientService } from 'src/app/services/client.service';
import { ClientGetAllDTO } from 'src/app/services/interfaces/clientgetalldto.inteface';

@Component({
  selector: 'app-clients',
  templateUrl: './clients.component.html',
  styleUrls: ['./clients.component.scss']
})
export class ClientsComponent implements OnInit {
  clients: Client[] = [];
  clientToShow: Client[] = [];
  genreEnumValues!: String[];

  constructor(
    private clientService : ClientService
   ){}

  async ngOnInit() {  
    const clientGetAllDTOs = await this.clientService.getAllClient();
    //mapping
    clientGetAllDTOs.map((value:ClientGetAllDTO)=>{
        const client:Client = {
          id:value.id,
          name: value.name,
          firstname: value.firstname,
          email: value.email,
          adresse: value.adresse
        }
        this.clients.push(client);
      })

    this.clientToShow = this.clients;
  }


  onSearchClicked=(searchClicked : {search:string})=>{
    this.clientToShow = this.clients.filter((value) =>{
      return value.name.toLowerCase() === searchClicked.search ;
    })
  }



}
