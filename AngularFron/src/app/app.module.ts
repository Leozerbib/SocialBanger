import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { RouterModule } from '@angular/router';

import { AppRoutingModule } from './app-routing.module';
import { JwtInterceptor } from './util/jwt.interceptor';
import { ErrorInterceptor } from './util/error.interceptor';
import { AppComponent } from './app.component';
import { AlertComponent } from './component/util/alert/alert.component';
import { HomeComponent } from './component/page/home/home.component';

// Import necessary Angular modules
import { CommonModule } from '@angular/common'; // Import CommonModule for ngClass
import { FormsModule } from '@angular/forms'; // Import FormsModule if needed for template-driven forms
import { CardAmisComponent } from './component/page/template/card-amis/card-amis.component';
import { CardPublicationComponent } from './component/page/template/card-publication/card-publication.component';
import { ButtonModule } from 'primeng/button';
import { CardModule } from 'primeng/card';
import { TabMenuModule } from 'primeng/tabmenu';
import { NavbarComponent } from './component/util/navbar/navbar.component';
import { ProgressSpinnerModule } from 'primeng/progressspinner';
import { PanelModule } from 'primeng/panel';
import { AvatarModule } from 'primeng/avatar';
import { CardCompteComponent } from './component/page/template/card-compte/card-compte.component';
import { CardAcountInfoComponent } from './component/page/template/card-acount-info/card-acount-info.component';
import { CardPubliAccountComponent } from './component/page/template/card-acount-info/card-publi-account/card-publi-account.component';
import { CardInfoProfileComponent } from './component/page/template/card-acount-info/card-info-profile/card-info-profile.component';
import { CardProfileInfoComponent } from './component/page/template/card-profile-info/card-profile-info/card-profile-info.component';
import { ForYouPageComponent } from './component/page/template/forYou-page/for-you-page/for-you-page.component';
import { PublicationComponent } from './component/page/template/publication/publication/publication.component';


@NgModule({
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    HttpClientModule,
    AppRoutingModule,
    RouterModule, // Ensure RouterModule is imported
    CommonModule, // Ensure CommonModule is imported
    FormsModule, // Import FormsModule if needed
    ButtonModule,
    CardModule,
    TabMenuModule,
    ProgressSpinnerModule,
    PanelModule,
    AvatarModule
  ],
  declarations: [
    AppComponent,
    AlertComponent,
    HomeComponent,
    CardAmisComponent,
    CardPublicationComponent,
    NavbarComponent,
    CardCompteComponent,
    CardAcountInfoComponent,
    CardPubliAccountComponent,
    CardInfoProfileComponent,
    CardProfileInfoComponent,
    ForYouPageComponent,
    PublicationComponent
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true },
    { provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true },
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
