import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home.component';
import { CardAmisComponent } from '../template/card-amis/card-amis.component';




const routes: Routes = [
  {
      path: '', component: HomeComponent,
      children: [
      ]
  }
];
@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class HomeRoutingModule { }