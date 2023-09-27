import { Component, OnInit } from '@angular/core';

import { ActivatedRoute } from '@angular/router';
import { HttpService } from '../../services/http.service';
import { Dvd } from '../../utils/models/dvd.interface';

@Component({
  selector: 'app-dvd-item',
  templateUrl: './dvd-item.component.html',
  styleUrls: ['./dvd-item.component.scss']
})
export class DvdItemComponent {
  path: string='dvds';
  id: number|any;
  currentDvd!: Dvd;

  constructor(private route:ActivatedRoute, private httpService: HttpService){};

  ngOnInit(): void {

    this.id = Number(this.route.snapshot.paramMap.get('id'));

    if(this.id != null){
      this.getDvdById(this.path, this.id);
    }

  }

  public getDvdById(path:string, id:number){
    this.httpService.getById(path, id).subscribe({
      next:(response:Dvd)=> this.currentDvd = response,
      error: (err: Error)=>console.error("Error getDvdById"),
      complete: ()=>console.log('display dvd ok')
    })

  }


}
