
﻿import { Component } from '@angular/core';

import { AccountService } from './service/User/uer-service.service';
import { User } from './model/User/user.model';

@Component({ selector: 'app-root', templateUrl: 'app.component.html' })
export class AppComponent {
    user?: User | null;

    constructor(private accountService: AccountService) {
        this.accountService.user.subscribe(x => this.user = x);
    }

    logout() {
        this.accountService.logout();
    }
}
