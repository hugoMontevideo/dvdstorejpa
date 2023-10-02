import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DvdstoreComponent } from './dvd/dvdstore/dvdstore.component';
import { DvdItemComponent } from './dvd/dvd-item/dvd-item.component';
import { DvdFormComponent } from './dvd/dvd-form/dvd-form.component';
import { ClientsComponent } from './client/clients/clients.component';
import { ClientFormComponent } from './client/client-form/client-form.component';
import { ClientItemComponent } from './client/client-item/client-item.component';

const routes: Routes = [
  { path: 'dvdstore', component: DvdstoreComponent},
  // { path: '**', redirectTo: 'dvdstore'},
  { path: 'dvdstore/dvds/:id', component: DvdItemComponent},
  { path: 'dvdstore/form', component: DvdFormComponent},
  { path: 'dvdstore/form/:id', component: DvdFormComponent},
  { path: 'clients', component: ClientsComponent},
  { path: 'clients/:id', component: ClientItemComponent},
  { path: 'clients/form', component: ClientFormComponent},
  { path: 'clients/form/:id', component: ClientFormComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
