
import { Component,OnInit } from '@angular/core';

import { AccountService } from './service/User/uer-service.service';
import { User } from './model/User/user.model';

@Component({ 
    selector: 'app-root', 
    templateUrl: 'app.component.html' ,
    styleUrls: ['app.component.scss']
})
export class AppComponent implements OnInit{
    user?: User | null;

    ngOnInit(): void{
    }






}
