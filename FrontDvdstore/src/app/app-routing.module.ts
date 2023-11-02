import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';
import { DvdItemComponent } from './admin/dvd/dvd-item/dvd-item.component';
import { DvdFormComponent } from './admin/dvd/dvd-form/dvd-form.component';
import { ClientsComponent } from './admin/client/clients/clients.component';
import { ClientItemComponent } from './admin/client/client-item/client-item.component';
import { ClientFormComponent } from './admin/client/client-form/client-form.component';
import { VentesComponent } from './admin/vente/ventes/ventes.component';
import { VentesFormComponent } from './admin/vente/ventes-form/ventes-form.component';
import { PanierComponent } from './admin/core/panier/panier.component';
import { PanierFormComponent } from './admin/core/panier-form/panier-form.component';
import { DvdstoreComponent } from './admin/dvd/dvdstore/dvdstore.component';
import { PanierItemComponent } from './admin/core/panier-item/panier-item.component';


const routes: Routes = [
  // {
  //   path: '',
  //   loadChildren: () => import('./admin/dvd/dvdstore/dvdstore.module').then( m => m.DvdstorePageModule)
  // },
  {
    path: 'login',
    loadChildren: () => import('./login/login.module').then( m => m.LoginPageModule)
  },

  { path: '', component: DvdstoreComponent},
  // { path: 'login', component: DvdstoreComponent},
  { path: 'dvds/:id', component: DvdItemComponent},
  { path: 'form', component: DvdFormComponent},
  { path: 'form/:id', component: DvdFormComponent},
  // { path: 'dvdstore/clients', component: ClientsComponent},
  // { path: 'dvdstore/clients/:id', component: ClientItemComponent},
  // { path: 'dvdstore/clients/form', component: ClientFormComponent},
  // { path: 'dvdstore/clients/form/:id', component: ClientFormComponent},
  // { path: 'dvdstore/ventes', component: VentesComponent},
  // { path: 'dvdstore/ventes/form', component: VentesFormComponent},
  { path: 'panier', component: PanierComponent},
  { path: 'panier/:id', component: PanierItemComponent},
  { path: 'panier/form/:id', component: PanierFormComponent},

];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }


  // { path: 'login', component: LoginComponent},
  // { path: 'dvdstore', component: DvdstoreComponent},
  // { path: '**', redirectTo: 'dvdstore'},



  // import { DvdItemComponent } from './admin/dvd/dvd-item/dvd-item.component';
// import { DvdFormComponent } from './admin/dvd/dvd-form/dvd-form.component';
// import { ClientsComponent } from './admin/client/clients/clients.component';
// import { ClientFormComponent } from './admin/client/client-form/client-form.component';
// import { ClientItemComponent } from './admin/client/client-item/client-item.component';
// import { VentesComponent } from './admin/vente/ventes/ventes.component';
// import { VentesFormComponent } from './admin/vente/ventes-form/ventes-form.component';
// import { PanierComponent } from './admin/core/panier/panier.component';
// import { PanierFormComponent } from './admin/core/panier-form/panier-form.component';
// import { DvdstoreModule } from './admin/dvd/dvdstore/dvdstore.module';