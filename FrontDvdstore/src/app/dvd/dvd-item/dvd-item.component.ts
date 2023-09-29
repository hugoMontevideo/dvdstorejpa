import { Component, OnInit } from '@angular/core';

import { ActivatedRoute } from '@angular/router';
import { HttpService } from '../../services/http.service';
import { Dvd } from '../../utils/models/dvd.interface';
import { environment } from 'src/environments/environments';

@Component({
  selector: 'app-dvd-item',
  templateUrl: './dvd-item.component.html',
  styleUrls: ['./dvd-item.component.scss']
})
export class DvdItemComponent {
  table: string='dvds';
  id!: number|null;
  currentDvd!: Dvd;
  ENV_DEV_IMG = `${environment.apiImg}/`;

  constructor(private route:ActivatedRoute, private httpService: HttpService){};

  ngOnInit(): void {

    this.id = Number(this.route.snapshot.paramMap.get('id'));

    if(this.id != null){
      this.getDvdById(this.table, this.id);
    }

  }

  public getDvdById(table:string, id:number){
    this.httpService.getById(table, id).subscribe({
      next:(response:Dvd)=> this.currentDvd = response,
      error: (err: Error)=>console.error("Error getDvdById"),
      complete: ()=>console.log(this.currentDvd)
    })

  }



}
