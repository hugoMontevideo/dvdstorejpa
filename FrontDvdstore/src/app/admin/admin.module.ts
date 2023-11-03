import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { FormsModule } from '@angular/forms';

import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';

import {IonicModule } from '@ionic/angular';



@NgModule({
  declarations: [
  ],
  imports: [
    BrowserModule,
    CommonModule,
    FormsModule,
    RouterModule,
    IonicModule
  ],
  providers:[ 
    
  ]
})

export class AdminModule { }

// import { DvdItemComponent } from './dvd/dvd-item/dvd-item.component';
// import { DvdFormComponent } from './dvd/dvd-form/dvd-form.component';
// import { ClientsComponent } from './client/clients/clients.component';
// import { ClientItemComponent } from './client/client-item/client-item.component';
// import { ClientFormComponent } from './client/client-form/client-form.component';
// import { VentesComponent } from './vente/ventes/ventes.component';
// import { VentesFormComponent } from './vente/ventes-form/ventes-form.component';

// import { HeaderComponent } from './core/components/header/header.component';
// import { SidebarComponent } from './core/components/sidebar/sidebar.component';
// import { RouteReuseStrategy } from '@angular/router';
// import { PanierComponent } from './core/panier/panier.component';
// import { PanierItemComponent } from './core/panier-item/panier-item.component';
// import { PanierFormComponent } from './core/panier-form/panier-form.component';