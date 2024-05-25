import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HomeRoutingModule } from './home-routing.module';
import { CardAmisComponent } from '../template/card-amis/card-amis.component';
import { CardPublicationComponent } from '../template/card-publication/card-publication.component';
import { CardCompteComponent } from '../template/card-compte/card-compte.component';



@NgModule({
  declarations: [
    CardAmisComponent,
    CardPublicationComponent,
    CardCompteComponent
  ],
  imports: [
    CommonModule,
    HomeRoutingModule,
  ],
})
export class HomeModule { }
