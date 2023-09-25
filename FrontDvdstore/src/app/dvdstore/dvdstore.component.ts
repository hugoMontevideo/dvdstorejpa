import { Component } from '@angular/core';
import { HttpService } from '../services/http.service';

@Component({
  selector: 'app-dvdstore',
  templateUrl: './dvdstore.component.html',
  styleUrls: ['./dvdstore.component.scss']
})
export class DvdstoreComponent {
  path: string = "dvds";
  dvds: any[]= [];

  constructor(private httpService: HttpService){}

  ngOnInit(): void {
    this.getDvds(this.path);
  }


  public getDvds(path:string){
    this.httpService.getData(path).subscribe({
      next:(response)=> this.dvds = response,
      error:(err:Error)=>(console.log("page home all dvds "+ err)),
      complete: ()=>console.log("all dvds ok")
    })


  }


}
