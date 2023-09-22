import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DvdstoreComponent } from './dvdstore/dvdstore.component';

const routes: Routes = [
  { path: 'dvdstore', component: DvdstoreComponent},
  { path: '**', redirectTo: 'dvdstore'},
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
