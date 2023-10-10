import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { ClientService } from 'src/app/admin/services/client.service';
import { JwtAxiosService } from 'src/app/services/JwtAxios.service';
import { HttpService } from 'src/app/admin/services/http.service';
import { ClientGetAllDTO } from 'src/app/admin/services/interfaces/clientgetalldto.inteface';
import { DvdGetAllDTO } from 'src/app/admin/services/interfaces/dvdgetalldto.inteface';
import { VenteGetAllDTO } from 'src/app/admin/services/interfaces/ventegetalldto.inteface';
import { VenteService } from 'src/app/admin/services/venteService';
import { Client } from 'src/app/admin/utils/model/client.interface';
import { Vente } from 'src/app/admin/utils/model/vente.interface';
import { environment } from 'src/environments/environments';

@Component({
  selector: 'app-ventes-form',
  templateUrl: './ventes-form.component.html',
  styleUrls: ['./ventes-form.component.scss']
})
export class VentesFormComponent implements OnInit{
  legend: string = "Ajouter";
  table: string ="ventes";
  ENV_DEV: string = environment.apiUrl;
  clientsToSelect!: Client[];
  id!:number;
  clientGetAllDTOs!: ClientGetAllDTO[];
  dvdGetAllDTOs!: DvdGetAllDTO[];
  currentVente: Vente = {
    id: 0,
    dateDeVente: '2023-05-15',
    dvdstore_id: 0,
    dvdstore_name: '',
    quantite: 0,
    client_id: 0,
    client_name: '',
    montant: 0
  }
  genreEnumValues!: String[];    // liste de genre de dvd
  venteGetAllDTO!: VenteGetAllDTO;

  constructor(private venteService:VenteService,
    private route:ActivatedRoute,
    private httpService: HttpService,
    private clientService: ClientService,
    private jwtAxiosService : JwtAxiosService
    ){};

    async ngOnInit(){
      this.clientGetAllDTOs= await this.clientService.getAllClient();
      this.dvdGetAllDTOs= await this.jwtAxiosService.getAllDvd("dvds");
    }

    onSubmit = (form:NgForm) => {
      // const formData = new FormData();
      // formData.append('dateDeVente', this.currentVente.dateDeVente);
      // formData.append('dvdstore_id', this.currentVente.dvdstore_id.toString());
      // formData.append('quantite',  this.currentVente.quantite.toString());
      // formData.append('client_id', this.currentVente.client_id.toString() );  

      this.venteService.addVente(form.value);
    } // onSubmit






}
