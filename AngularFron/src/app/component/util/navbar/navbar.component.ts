import { Component } from '@angular/core';
import { AccountService } from '../../../service/User/uer-service.service';
import { User } from '../../../model/User/user.model';
import { MenuItem } from 'primeng/api';
import { Userall } from '../../../model/User/userall.model';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.scss'
})
export class NavbarComponent {
  user?: Userall | null;



  items: MenuItem[] = [
    {
      label: 'Home',
      icon: 'pi pi-fw pi-home',
      routerLink: '/home'
    },
    {
      label: 'For you',
      icon: 'pi pi-fw pi-user',
      routerLink: '/profile'
    },
    {
      label: 'Message',
      icon: 'pi pi-fw pi-users',
      routerLink: '/friends'
    },
    {
      label: 'Publications',
      icon: 'pi pi-fw pi-book',
      routerLink: '/publications'
    },
    {
      label: 'Logout',
      icon: 'pi pi-fw pi-power-off',
      command: () => this.logout()
    }
  ]

  activeItem: MenuItem = this.items[0];


  constructor(private accountService: AccountService) {
    this.accountService.user.subscribe(x => this.user = x);
    this.user = this.accountService.userValue;

  }

  logout() {
  }

  onTabChange(event: any) {
    this.activeItem = event.activeItem;
  }


}
