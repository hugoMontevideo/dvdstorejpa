import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DvdstoreComponent } from './admin/dvd/dvdstore/dvdstore.component';
import { DvdItemComponent } from './admin/dvd/dvd-item/dvd-item.component';
import { DvdFormComponent } from './admin/dvd/dvd-form/dvd-form.component';
import { ClientsComponent } from './admin/client/clients/clients.component';
import { ClientFormComponent } from './admin/client/client-form/client-form.component';
import { ClientItemComponent } from './admin/client/client-item/client-item.component';
import { VentesComponent } from './admin/vente/ventes/ventes.component';
import { VentesFormComponent } from './admin/vente/ventes-form/ventes-form.component';
import { LoginComponent } from './login/login.component';
import { PanierComponent } from './admin/core/panier/panier.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent},
  { path: 'dvdstore', component: DvdstoreComponent},
  // { path: '**', redirectTo: 'dvdstore'},
  { path: 'dvdstore/dvds/:id', component: DvdItemComponent},
  { path: 'dvdstore/form', component: DvdFormComponent},
  { path: 'dvdstore/form/:id', component: DvdFormComponent},
  { path: 'dvdstore/clients', component: ClientsComponent},
  { path: 'dvdstore/clients/:id', component: ClientItemComponent},
  { path: 'dvdstore/clients/form', component: ClientFormComponent},
  { path: 'dvdstore/clients/form/:id', component: ClientFormComponent},
  { path: 'dvdstore/ventes', component: VentesComponent},
  { path: 'dvdstore/ventes/form', component: VentesFormComponent},
  { path: 'panier', component: PanierComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
