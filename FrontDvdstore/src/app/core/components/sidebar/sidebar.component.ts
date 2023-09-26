import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.scss']
})
export class SidebarComponent implements OnInit {

  @Input() genreEnumValues!: String[];
  @Output() genreClicked = new EventEmitter< {genre:string} >();

  // genreEnum = GenreEnum;
  // genreEnumValues = Object.values(this.genreEnum);


  ngOnInit(): void {

   
  }

  handleGenreClick( genre:string){
    
    this.genreClicked.emit({genre});

  }


}
