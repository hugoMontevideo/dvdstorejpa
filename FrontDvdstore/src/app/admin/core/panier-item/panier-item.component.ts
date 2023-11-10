import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpService } from '../../services/http.service';
import { PanierDTO } from '../panier/panierDTO.interface';
import { environment } from 'src/environments/environments';
import { VenteAddDTO } from '../../services/interfaces/venteAddDTO.interface';



@Component({
  selector: 'app-panier-item',
  templateUrl: './panier-item.component.html',
  styleUrls: ['./panier-item.component.scss']
})
export class PanierItemComponent implements OnInit {
  ENV_ICON = `${environment.apiImg}/icons/`;
  table: string = "panier"
  id!: number;
  titlePage: string = "Mon panier";
  bottomPage!: string;
  currentPanier : PanierDTO = {
    id: 0,
    amount: 0,
    clientId: 0,
    createdAt: new Date,
    dvds: []
  };
 
  constructor(private route:ActivatedRoute, 
    private httpService: HttpService,
    private router: Router){};

  ngOnInit(): void {
    this.currentPanier.clientId = Number(this.route.snapshot.paramMap.get('id'));

    if(this.currentPanier.clientId != null){
      this.getPanierByClientId(this.currentPanier.clientId, this.currentPanier.clientId );
    }
  }

  onPay = (): void => {
    let venteDTO : VenteAddDTO = {
      panierId: this.currentPanier.id,
      amount: this.currentPanier.amount,
      clientId: this.currentPanier.clientId,
      dvds: this.currentPanier.dvds
    }
    this.httpService.addVente( venteDTO )
    .subscribe({
        next:(response)=> { 
              this.titlePage = "Achat effectué";
              this.bottomPage = "Merci pour votre achat. A bientôt !"
            },
        error:(err:Error)=>{
              (console.log("page panier vente troubles "+ err));
              this.titlePage = "Achat effectué";
              this.bottomPage = "Merci pour votre achat. A bientôt !"
           } 
      });
  }

  getPanierByClientId = ( id:number, panierId: number)=>{
    this.httpService.getPanierByClientId(id, panierId)
    .subscribe({
      next:( response: PanierDTO )=> {
          this.currentPanier = response;      
          },
      error: (err: Error)=>{
          console.error(`Error getDvdById ${err}`);
          this.router.navigateByUrl("/");
        },
      complete: ()=>{
      }
    })
  }

  deleteDvdPanier = ( index:number ):void => {    
    this.currentPanier.amount -= this.currentPanier.dvds[index].dvdSubtotal;
    // we pass client's id and panierDvd's id
    this.httpService.deletePanierDvd(
            this.currentPanier.clientId, 
            this.currentPanier.dvds[index].id,
            this.currentPanier.dvds[index].dvdId,
            this.currentPanier.dvds[index].dvdQuantite
          )
    .subscribe({
        next:(response)=> { 
              // on efface l'element supprimé pour l'affichage
              this.currentPanier.dvds.splice(index,1);   
            },
        error:(err:Error)=>{
              (console.log("page panier "+ err));
               // on efface l'element supprimé pour l'affichage
               this.currentPanier.dvds.splice(index,1);   
           } ,
        complete: ()=>console.log("end traitement")
      });
  }

  testCalculate = (a:number,b:number){
      return a+b;
  }


}





// trash

 // display = ( index:number ):void => {
  //   this.indexDvd = index;
  // }

  // indexDvd: number = 0;  // index du détail dvd 

