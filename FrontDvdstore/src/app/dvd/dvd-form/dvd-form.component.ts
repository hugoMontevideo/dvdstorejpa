import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { DvdDTO } from '../../services/interfaces/dvdDTO.interface';
import { GenreEnum } from 'src/app/utils/enum/GenreEnum';

@Component({
  selector: 'app-dvd-form',
  templateUrl: './dvd-form.component.html',
  styleUrls: ['./dvd-form.component.scss']
})
export class DvdFormComponent implements OnInit{
  legend: string = "Ajouter un dvd";

  dvdDTO: DvdDTO = {
    name:'',
    genre:'',
    quantite:0,
    prix:0,
    picture:'',
  }
  genreEnum = GenreEnum;
  genreEnumValues = Object.values(this.genreEnum);

  ngOnInit(): void {
    console.log(this.dvdDTO);
    
  }


  formulaire = (form:NgForm)=>{
    console.log(form);
  }

}
