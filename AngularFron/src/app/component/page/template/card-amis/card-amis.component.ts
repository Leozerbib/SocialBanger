import { Component, Input, OnInit } from '@angular/core';
import { Status } from '../../../../model/enum/status';
import { UserDto } from '../../../../model/User/user-dto.model';


@Component({
  selector: 'app-card-amis',
  templateUrl: './card-amis.component.html',
  styleUrls: ['./card-amis.component.scss','../../../../../../node_modules/bootstrap-icons/font/bootstrap-icons.css'],
})
export class CardAmisComponent {
  @Input() friend!: UserDto;
  isConnected: boolean = false;

  constructor() {
    
  }

  ngOnInit(): void {
    if (this.friend.userStatus == Status.Active) {
      this.isConnected = true;
    }
    else {
      this.isConnected = false;
    }
  }

}
