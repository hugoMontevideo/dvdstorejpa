import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DvdstoreComponent } from './dvd/dvdstore/dvdstore.component';
import { DvdItemComponent } from './dvd/dvd-item/dvd-item.component';
import { DvdFormComponent } from './dvd/dvd-form/dvd-form.component';


const routes: Routes = [
  { path: 'dvdstore', component: DvdstoreComponent},
  // { path: '**', redirectTo: 'dvdstore'},
  { path: 'dvdstore/dvds/:id', component: DvdItemComponent},
  { path: 'dvdstore/form', component: DvdFormComponent},
  { path: 'dvdstore/form/:id', component: DvdFormComponent},
    
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
