import { Component, OnInit } from '@angular/core';
import { Platform } from '@ionic/angular';
import { SharedService } from './services/shared.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})

export class AppComponent implements OnInit {
  title = 'ngDvdstore';
  currentPlatform!: string ;


  constructor(public platform: Platform,
      private sharedService: SharedService){};


ngOnInit(): void {

  // distinguish and share platform type
  if( this.platform.is("android") ){

    this.sharedService.platform = "android";

  }else if(this.platform.is("ios")){

    this.sharedService.platform = "ios";

  }else if(this.platform.is("desktop")){

    this.sharedService.platform = "desktop";

  }


}




  








}
