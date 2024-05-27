import { Component } from '@angular/core';
import { Userall } from '../../../../model/User/userall.model';
import { AccountService } from '../../../../service/User/uer-service.service';
import { PostPlus } from '../../../../model/Post/post-plus.model';

@Component({
  selector: 'app-card-acount-info',
  templateUrl: './card-acount-info.component.html',
  styleUrl: './card-acount-info.component.scss'
})
export class CardAcountInfoComponent {
  user!: Userall | null;
  posts!: PostPlus[] | null;

  constructor(private accountService: AccountService,) {
    this.user = this.accountService.userValue;
    this.posts = this.user?.posts as PostPlus[]; // Add null check using the optional chaining operator
  }

  ngOnInit(): void {
    
  }
}
