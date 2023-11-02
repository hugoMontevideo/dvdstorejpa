import { Component } from '@angular/core';
import { HttpService } from '../../services/http.service';
import { PanierDTO } from './panierDTO.interface';
import { PanierRequest } from './panierRequest.interface';

@Component({
  selector: 'app-panier',
  templateUrl: './panier.component.html',
  styleUrls: ['./panier.component.scss']
})
export class PanierComponent {    // todo  **** page à revoir
  table: string = "panier"
  indexDvd: number = 0;  // index du détail dvd 
  panierDTOs: PanierDTO[] | any = [];

  currentPanier : PanierDTO = {
    id: 0,
    amount: 0,
    clientId: 0,
    createdAt: new Date,
    dvds: []
  };

  constructor( private httpService: HttpService ){}

   ngOnInit( ) {
    this.getPaniers(this.table);
  }

  getPaniers= (table:string) => {
    this.httpService.getPaniers(table)
    .subscribe({
      next:(response: PanierRequest[])=> {
        for( let i=0; i<response.length; i++){
          // conversion number (Long) to Date
            let date = new Date(response[i].createdAt);
            let panierDto = {
              id: response[i].id,
              amount: response[i].amount,
              clientId: response[i].clientId,
              createdAt: date,
              dvds: response[i].dvds,
            }
            this.panierDTOs.push(panierDto);
          }         
        },
      error:(err:Error)=>(console.log("page panier "+ err)),
      complete: ()=>console.log("end traitement")
    })
  }

  display = ( index:number ):void => {
    this.indexDvd = index;
  }

  deleteDvdPanier = ( index:number ):void => {
    console.log(this.panierDTOs[this.indexDvd].dvds[index].id);
    // on passe l'id du panierDvd
    this.httpService.deletePanierDvd(
      this.panierDTOs.clientId, 
      this.panierDTOs[this.indexDvd].dvds[index].id,
      this.currentPanier.dvds[index].dvdId,     
      this.currentPanier.dvds[index].dvdQuantite     
      )
    .subscribe({
        next:(response)=> { 
              // on efface l'element supprimé pour l'affichage
              this.panierDTOs[this.indexDvd].dvds.splice(index,1);   
            },
        error:(err:Error)=>{
              (console.log("page panier "+ err));
               // on efface l'element supprimé pour l'affichage
               this.panierDTOs[this.indexDvd].dvds.splice(index,1);   
           } ,
        complete: ()=>console.log("end traitement")
      });
    
  }
  delete = ( index:number ):void => {

    console.log(index);
  }

}
