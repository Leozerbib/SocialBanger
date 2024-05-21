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

@NgModule({
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    HttpClientModule,
    AppRoutingModule,
    RouterModule, // Ensure RouterModule is imported
    CommonModule, // Ensure CommonModule is imported
    FormsModule // Import FormsModule if needed
  ],
  declarations: [
    AppComponent,
    AlertComponent,
    HomeComponent
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true },
    { provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true },
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
