import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpService } from 'src/app/admin/services/http.service';
import { Client } from 'src/app/admin/utils/model/client.interface';

@Component({
  selector: 'app-client-item',
  templateUrl: './client-item.component.html',
  styleUrls: ['./client-item.component.scss']
})
export class ClientItemComponent implements OnInit{
  table: string='clients';
  currentClient!: Client;
  id!: number|null;

  constructor(private route:ActivatedRoute, 
    private httpService: HttpService,
    private router: Router){};

  ngOnInit(): void {

    this.id = Number(this.route.snapshot.paramMap.get('id'));

    if(this.id != null){
      this.getClientById(this.table, this.id);
    }

  }

  getClientById=(table:string, id:number)=>{
    this.httpService.getById(table, id).subscribe({
      next:(response:Client)=> this.currentClient = response,
      error: (err: Error)=>console.error("Error getDvdById"),
      complete: ()=>console.log(this.currentClient)
    })
  }

  onDelete = (id: number|null): void => {
    this.httpService.deleteById( this.table, this.id).subscribe({
      next:(response)=> console.log(response),
      error: (err: Error)=>{  
          console.error("error on deleting");   /// *** TODO **** Gérer cette erreur !
          this.router.navigateByUrl("clients");
        },
      complete:()=> this.router.navigateByUrl("clients")
    });
  }




}
