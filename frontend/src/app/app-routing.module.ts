import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AadharCardComponent } from './aadhar-card/aadhar-card.component';

const routes: Routes = [
  {
    path: 'update',
    component: AadharCardComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
