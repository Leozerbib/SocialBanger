import { Component, Input, OnInit } from '@angular/core';
import { User } from '../../../../../model/User/user.model';
import { Userall } from '../../../../../model/User/userall.model';
import { AccountService } from '../../../../../service/User/uer-service.service';

@Component({
  selector: 'app-card-info-profile',
  templateUrl: './card-info-profile.component.html',
  styleUrl: './card-info-profile.component.scss'
})
export class CardInfoProfileComponent implements OnInit{

@Input() user!: Userall;
username : string = 'username'
sub : boolean = true;

constructor(private accountService: AccountService) {

}

ngOnInit(): void {
  console.log(this.user)
  if (this.accountService.userValue?.id == this.user?.id) {
    this.sub = false;
  }
}



}
