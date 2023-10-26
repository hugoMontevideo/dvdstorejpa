import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpService } from '../../services/http.service';
import { Dvd } from '../../utils/model/dvd.interface';
import { environment } from 'src/environments/environments';

@Component({
  selector: 'app-dvd-item',
  templateUrl: './dvd-item.component.html',
  styleUrls: ['./dvd-item.component.scss']
})
export class DvdItemComponent implements OnInit{
  
  ENV_DEV_IMG = `${environment.apiImg}/`;
  table: string='dvds';
  id!: number;
  currentDvd!: Dvd;

  constructor(private route:ActivatedRoute, 
          private httpService: HttpService,
          private router: Router){};

  ngOnInit(): void {

    this.id = Number(this.route.snapshot.paramMap.get('id'));

    if(this.id != null){
      this.getDvdById(this.table, this.id);
    }
  }

  getDvdById = (table:string, id:number)=>{
    this.httpService.getById(table, id)
    .subscribe({
      next:(response:Dvd)=> this.currentDvd = response,
      error: (err: Error)=>{
          console.error(`Error getDvdById ${err}`);
          this.router.navigateByUrl("/dvdstore");
        },
      complete: ()=>{
      }
    })
  }

  onDelete = (id: number): void => {
    this.httpService.deleteById( this.table, this.id)
    .subscribe({
      next:(response)=> console.log(response),
      error: (err: Error)=>{  
          console.error("error on deleting");   /// *** TODO **** Gérer cette erreur !
          this.router.navigateByUrl("dvdstore");
        },
      complete:()=> this.router.navigateByUrl("dvdstore")
    });
  }
  onModifyDvd = (id:number) =>{
    console.log("hello");
    
    this.router.navigateByUrl('/dvdstore');
  }


}
