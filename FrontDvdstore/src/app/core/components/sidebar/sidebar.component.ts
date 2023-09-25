import { Component } from '@angular/core';
import { GenreEnum } from 'src/app/utils/enum/GenreEnum';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.scss']
})
export class SidebarComponent {

  genreEnum = GenreEnum;
  genreEnumValues = Object.values(this.genreEnum);


}
