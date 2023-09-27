import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { DvdDTO } from '../../services/interfaces/dvdDTO.interface';
import { GenreEnum } from 'src/app/utils/enum/GenreEnum';
import { DvdService } from 'src/app/services/dvd.service';

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

  constructor(private dvdService:DvdService){};

  ngOnInit(): void {

    
  }

  onSubmit = async ()=>{
   await  this.dvdService.addDvd(this.dvdDTO);
  }

}
