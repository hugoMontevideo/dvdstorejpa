import { Component, OnInit,ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpService } from '../../services/http.service';
import { Dvd } from '../../utils/model/dvd.interface';
import { environment } from 'src/environments/environments';
import { User } from '../../utils/model/user.interface';
import { IonModal } from '@ionic/angular';
import { OverlayEventDetail } from '@ionic/core/components';
import { PanierDvdInsertDTO1 } from '../../core/panier/panierDvdInsertDTO1.interface';
import { SharedService } from 'src/app/services/shared.service';


@Component({
  selector: 'app-dvd-item',
  templateUrl: './dvd-item.component.html',
  styleUrls: ['./dvd-item.component.scss']
})
export class DvdItemComponent implements OnInit{
  skipIon: boolean = true; // false during tests
  platform!: string;
  ENV_DEV_IMG = `${environment.apiImg}/`;
  table: string='dvds';
  dvdId!: number;
  currentDvd: Dvd={
      id:0,
      name:'',
      genre:'',
      quantite:0,
      prix:0,
      picture:''
    };

  currentUser!:User;

  panierDvd: PanierDvdInsertDTO1 = {
    dvdId:0, 
    panierId: 2,
    dvdSubtotal: 0,
    clientId: 0,
    dvdQuantite: 0
  }

   //  ionic modal
   @ViewChild(IonModal) modal!: IonModal;
   quantity!: string;
   message = '';

  constructor(private route:ActivatedRoute, 
          private httpService: HttpService,
          private router: Router,
          public sharedService: SharedService
          ){};

  ngOnInit(): void {
    this.platform = this.sharedService.platform;
    this.dvdId = Number(this.route.snapshot.paramMap.get('id'));

    let stringUser: any = sessionStorage.getItem("currentUser");
    this.currentUser = JSON.parse(stringUser);

    if(this.dvdId != null){
      this.getDvdById(this.table,  this.dvdId );
    }
  }

  addPanierDvd = (panierdvd: PanierDvdInsertDTO1) => {
    
    this.httpService.addPanierDvd( panierdvd )
    .subscribe({
      next:(response)=>{console.log(response)},
    
      error: (err: Error)=>{
          console.error(`Error getDvdById ${err}`);
          this.router.navigateByUrl("/");
        },
      complete: ()=>{
      }
    })
  };

  getDvdById = ( table:string,  id:number) =>{
     this.httpService.getByIdTest(table, id)
    .subscribe({
      next:(response:Dvd)=> this.currentDvd = response,
      error: (err: Error)=>{
          console.error(`Error getDvdById ${ err.name }`);
          // this.router.navigateByUrl("/");
        },
      complete: ()=>{console.log("*", this.currentDvd);
      }
    })
  };

  onDelete = (id: number): void => {
    this.httpService.deleteById1( this.table, this.dvdId)
    .subscribe({
      next:(response)=> console.log(response),
      error: (err: Error)=>{  
          console.error("error on deleting"+ err);   /// *** TODO **** Gérer cette erreur !
          this.router.navigateByUrl("/");
        },
      complete:()=> this.router.navigateByUrl("/")
    });
  };

  cancel() {
    this.modal.dismiss(null, 'cancel');
  }

  confirm() {
    this.modal.dismiss(this.quantity, 'confirm');
  }

  onWillDismiss(event: Event) {
    const ev = event as CustomEvent<OverlayEventDetail<string>>;
    if (ev.detail.role === 'confirm') {
      let itemQuantity = Number(ev.detail.data);

      if( itemQuantity > this.currentDvd.quantite ){
        this.message = `${this.currentDvd.quantite } en stock. Veuillez choisir moins de dvds`;
      } else{
        // panierdvd hydration
        this.panierDvd.dvdId = this.dvdId;
        this.panierDvd.panierId = this.currentUser.id;
        this.panierDvd.clientId = this.currentUser.id;
        this.panierDvd.dvdSubtotal = this.currentDvd.prix*itemQuantity;
        this.panierDvd.dvdQuantite = itemQuantity;      

        this.addPanierDvd(this.panierDvd);
        this.currentDvd.quantite -= itemQuantity;  // updating stock
        this.message = `${ev.detail.data} dvds ajouté(s) = ${this.panierDvd.dvdSubtotal} €`;
      }

    }
  }


}
