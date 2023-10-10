import { Component, EventEmitter, Output, OnInit } from '@angular/core';
import { User } from 'src/app/admin/utils/model/user.interface';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit{

  @Output() searchClicked = new EventEmitter<{ search: string }>();
  searchText!:string;
  conButton:string = "Connexion";
  initials: string = "x";

  currentUser!:User;


  handleSearchClick(search: string){    
    this.searchClicked.emit({search});
  }

  ngOnInit(): void {
    let anything: any = sessionStorage.getItem('currentUser');
    if(anything != null){
      this.currentUser = JSON.parse(anything);
      this.initials=this.currentUser.username[0];
      this.conButton="Deconnexion";
    }
  }

}
