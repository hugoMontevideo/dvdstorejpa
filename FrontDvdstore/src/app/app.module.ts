import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
// import { LoginComponent } from './login/login.page';
import { RegisterComponent } from './register/register.component';
import { JWTTokenService } from './services/JWTTokens.service';
import { JWTInterceptorService } from './jwtinterceptor.service';
// import { DvdstoreComponent } from './admin/dvd/dvdstore/dvdstore.page';
import { PanierFormComponent } from './admin/core/panier-form/panier-form.component';
import { PanierComponent } from './admin/core/panier/panier.component';
import { PanierItemComponent } from './admin/core/panier-item/panier-item.component';
import { DvdItemComponent } from './admin/dvd/dvd-item/dvd-item.component';
import { VentesComponent } from './admin/vente/ventes/ventes.component';
import { VentesFormComponent } from './admin/vente/ventes-form/ventes-form.component';
import { DvdFormComponent } from './admin/dvd/dvd-form/dvd-form.component';
import { HeaderComponent } from './admin/core/components/header/header.component';
import { SidebarComponent } from './admin/core/components/sidebar/sidebar.component';
import { ClientFormComponent } from './admin/client/client-form/client-form.component';
import { ClientItemComponent } from './admin/client/client-item/client-item.component';
import { ClientsComponent } from './admin/client/clients/clients.component';
import { IonicModule, IonicRouteStrategy } from '@ionic/angular';
import { RouteReuseStrategy } from '@angular/router';
import { DvdstoreComponent } from './admin/dvd/dvdstore/dvdstore.component';



@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,  
    PanierFormComponent,
    PanierComponent,
    PanierComponent,
    PanierItemComponent,
    DvdItemComponent,
    // LoginComponent,
    RegisterComponent,
    DvdFormComponent,
    VentesComponent,
    VentesFormComponent,
    HeaderComponent,
    SidebarComponent,
    ClientFormComponent,
    ClientItemComponent,
    ClientsComponent,
    HeaderComponent,
    DvdstoreComponent,
    HeaderComponent,
    SidebarComponent,
    // DvdstoreComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,  
    HttpClientModule,
    FormsModule,
    IonicModule.forRoot(),

  ],
  providers: [
    JWTTokenService,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: JWTInterceptorService,
      multi: true
    },
    { provide: RouteReuseStrategy, 
      useClass: IonicRouteStrategy 
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
