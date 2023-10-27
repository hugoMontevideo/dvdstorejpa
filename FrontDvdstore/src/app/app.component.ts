import { Component, OnInit } from '@angular/core';
import { Platform } from '@ionic/angular';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})

export class AppComponent implements OnInit {
  title = 'ngDvdstore';
  currentPlatform: string = "android";


  constructor(public platform: Platform){};


ngOnInit(): void {
  
  if( this.platform.is("android") ){

    // todo   **********

    
  }else if(this.platform.is("ios")){

    // todo   **********


  }else if(this.platform.is("desktop")){

    // todo   **********


  }



}




  








}
