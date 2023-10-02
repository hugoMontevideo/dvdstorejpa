import { Component, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent {

  @Output() searchClicked = new EventEmitter<{ search: string }>();
  searchText!:string;

  initials: string = "x";


  handleSearchClick(search: string){    
    this.searchClicked.emit({search});
  }


}
