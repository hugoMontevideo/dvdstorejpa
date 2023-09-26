import { Component, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent {

  @Output() searchClicked = new EventEmitter<{ search: string }>();
  searchText!:string;


  handleSearchClick(search: string){
    console.log(search);
    
    this.searchClicked.emit({search});

  }


}
