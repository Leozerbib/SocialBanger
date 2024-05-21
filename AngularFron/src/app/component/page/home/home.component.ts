import { Component } from '@angular/core';

import { User } from '../../../model/User/user.model';
import { AccountService } from '../../../service/User/uer-service.service';

@Component({ templateUrl: 'home.component.html' })
export class HomeComponent {
    user: User | null;

    constructor(private accountService: AccountService) {
        this.user = this.accountService.userValue;
    }
}