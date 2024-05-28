import { Component, Input,OnInit } from '@angular/core';
import { User } from '../../../../model/User/user.model';
import { UserDto } from '../../../../model/User/user-dto.model';
import { Status } from '../../../../model/enum/status';
import { UserInfo } from '../../../../model/User/user-info.class';

@Component({
  selector: 'app-card-compte',
  templateUrl: './card-compte.component.html',
  styleUrl: './card-compte.component.scss'
})
export class CardCompteComponent implements OnInit{
  @Input() user!: UserInfo;
  isConnected: boolean = false;
  constructor() {
  }

  
  ngOnInit(): void {
    if (this.user.userStatus == Status.Active) {
      this.isConnected = true;
    }
    else {
      this.isConnected = false;
    }
  }

}
