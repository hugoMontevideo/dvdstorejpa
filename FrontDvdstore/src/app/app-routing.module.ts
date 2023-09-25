import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DvdstoreComponent } from './dvdstore/dvdstore.component';
import { DvdItemComponent } from './dvd-item/dvd-item.component';

const routes: Routes = [
  { path: 'dvdstore', component: DvdstoreComponent},
  // { path: '**', redirectTo: 'dvdstore'},
  { path: 'dvdstore/dvds/:id', component: DvdItemComponent},

  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
