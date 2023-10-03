import { Component, OnInit } from '@angular/core';
import { VenteGetAllDTO } from 'src/app/services/interfaces/ventegetalldto.inteface';
import { VenteService } from 'src/app/services/venteService';
import { Vente } from 'src/app/utils/models/vente.interface';

@Component({
  selector: 'app-ventes',
  templateUrl: './ventes.component.html',
  styleUrls: ['./ventes.component.scss']
})
export class VentesComponent implements OnInit {
  ventes: Vente[] = [];
  venteToShow: Vente[] = [];
  genreEnumValues!: String[];

  constructor(
    private venteService : VenteService
   ){}

   async ngOnInit() {  
    const venteGetAllDTOs = await this.venteService.getAllVente();
    //mapping
    venteGetAllDTOs.map((value:VenteGetAllDTO)=>{
        const dvd:Vente = {
          id:value.id,
          dateDeVente: value.dateDeVente,
          dvdstore_id: value.dvdstore_id,
          dvdstore_name: value.dvdstore_name,
          quantite: value.quantite,
          client_id: value.client_id,
          client_name: value.client_name,
          montant: value.montant
        }
        this.ventes.push(dvd);
      })

    this.venteToShow = this.ventes;
  }

  onSearchClicked=(searchClicked : {search:string})=>{
    this.venteToShow = this.ventes.filter((value) =>{
      return value.dvdstore_id === Number(searchClicked.search) ;
    })
  }

}
