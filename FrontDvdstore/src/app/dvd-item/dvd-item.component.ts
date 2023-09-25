import { Component, OnInit } from '@angular/core';
import { Dvd } from '../models/dvd.model';
import { ActivatedRoute } from '@angular/router';
import { HttpService } from '../services/http.service';

@Component({
  selector: 'app-dvd-item',
  templateUrl: './dvd-item.component.html',
  styleUrls: ['./dvd-item.component.scss']
})
export class DvdItemComponent {
  path: string='dvds';
  id: number|any;
  currentDvd: Dvd = new Dvd();

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
