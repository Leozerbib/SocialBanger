import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './component/page/home/home.component';
import { AuthGuard } from './util/auth.guard';
import { CardAcountInfoComponent } from './component/page/template/card-acount-info/card-acount-info.component';
import { CardInfoProfileComponent } from './component/page/template/card-acount-info/card-info-profile/card-info-profile.component';
import { CardProfileInfoComponent } from './component/page/template/card-profile-info/card-profile-info/card-profile-info.component';
import { ForYouPageComponent } from './component/page/template/forYou-page/for-you-page/for-you-page.component';

const accountModule = () => import('./component/page/account/acount/acount.module').then(x => x.AccountModule);

const routes: Routes = [
  { path: '', component: HomeComponent, canActivate: [AuthGuard] },
  { path: 'account', loadChildren: accountModule },
  { path: 'profile', component: CardAcountInfoComponent, canActivate: [AuthGuard] },
  { path: 'profile/:id', component: CardProfileInfoComponent, canActivate: [AuthGuard] },
  { path: 'foryou', component: ForYouPageComponent, canActivate: [AuthGuard] },


  // otherwise redirect to home
  { path: '**', redirectTo: '' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
