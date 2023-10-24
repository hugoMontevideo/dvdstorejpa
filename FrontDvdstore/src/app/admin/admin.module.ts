import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DvdstoreComponent } from './dvd/dvdstore/dvdstore.component';
import { DvdItemComponent } from './dvd/dvd-item/dvd-item.component';
import { DvdFormComponent } from './dvd/dvd-form/dvd-form.component';
import { ClientsComponent } from './client/clients/clients.component';
import { ClientItemComponent } from './client/client-item/client-item.component';
import { ClientFormComponent } from './client/client-form/client-form.component';
import { VentesComponent } from './vente/ventes/ventes.component';
import { VentesFormComponent } from './vente/ventes-form/ventes-form.component';
import { FormsModule } from '@angular/forms';
import { HeaderComponent } from './core/components/header/header.component';
import { SidebarComponent } from './core/components/sidebar/sidebar.component';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { PanierComponent } from './core/panier/panier.component';
import { PanierItemComponent } from './core/panier-item/panier-item.component';

@NgModule({
  declarations: [
    DvdstoreComponent,
    DvdItemComponent,
    DvdFormComponent,
    ClientsComponent,
    ClientItemComponent,
    ClientFormComponent,
    VentesComponent,
    VentesFormComponent,
    HeaderComponent,
    SidebarComponent,
    PanierComponent,
    PanierItemComponent,

  
  ],
  imports: [
    BrowserModule,
    CommonModule,
    FormsModule,
    RouterModule
  ],
  providers:[ 
  ]
})

export class AdminModule { }
