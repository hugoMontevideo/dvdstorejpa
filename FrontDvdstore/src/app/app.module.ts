import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { DvdstoreComponent } from './dvd/dvdstore/dvdstore.component';
import { CoreModule } from './core/core.module';
import { SharedModule } from './shared/shared.module';
import { HttpClientModule } from '@angular/common/http';
import { DvdItemComponent } from './dvd/dvd-item/dvd-item.component';
import { FormsModule } from '@angular/forms';
import { DvdFormComponent } from './dvd/dvd-form/dvd-form.component';

@NgModule({
  declarations: [
    AppComponent,
    DvdstoreComponent,
    DvdItemComponent,
    DvdFormComponent,
  
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule, 
    CoreModule,
    SharedModule, 
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
