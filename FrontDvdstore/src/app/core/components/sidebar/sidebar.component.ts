import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { SharedataService } from 'src/app/services/sharedata.service';
import { GenreEnum } from 'src/app/utils/enum/GenreEnum';

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

  constructor(private sharedata:SharedataService){}

  ngOnInit(): void {

   
  }

  handleGenreClick( genre:string){
    
    this.genreClicked.emit({genre});

  }


}
