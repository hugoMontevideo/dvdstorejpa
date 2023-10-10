import { Component, OnInit } from '@angular/core';
import { Client } from '../../utils/model/client.interface';
import { HttpService } from '../../services/http.service';

@Component({
  selector: 'app-clients',
  templateUrl: './clients.component.html',
  styleUrls: ['./clients.component.scss']
})
export class ClientsComponent implements OnInit {
  table: string = "clients";
  clients: Client[] = [];
  clientToShow: Client[] = [];
  genreEnumValues!: String[];

  constructor(
    private httpService: HttpService
   ){}

  async ngOnInit() {  
    this.getClients(this.table);
  }

  onSearchClicked=(searchClicked : {search:string})=>{
    this.clientToShow = this.clients.filter((value) =>{
      return value.name.toLowerCase() === searchClicked.search ;
    })
  }

  public getClients(table:string){
    this.httpService.getData(table)
    .subscribe({
      next:(response: Client[])=> this.clientToShow = response,
      error:(err:Error)=>(console.log("page home all dvds "+ err)),
      complete: ()=>console.table(this.clientToShow)
    })
  }


}

// const clientGetAllDTOs = await this.clientService.getAllClient();
// //mapping
// clientGetAllDTOs.map((value:ClientGetAllDTO)=>{
//     const client:Client = {
//       id:value.id,
//       name: value.name,
//       firstname: value.firstname,
//       email: value.email,
//       adresse: value.adresse
//     }
//     this.clients.push(client);
//   })

// this.clientToShow = this.clients;
