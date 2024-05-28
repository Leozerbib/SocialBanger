import { Component } from '@angular/core';
import { Userall } from '../../../../model/User/userall.model';
import { AccountService } from '../../../../service/User/uer-service.service';
import { PostPlus } from '../../../../model/Post/post-plus.model';
import { UserInfo } from '../../../../model/User/user-info.class';

@Component({
  selector: 'app-card-acount-info',
  templateUrl: './card-acount-info.component.html',
  styleUrl: './card-acount-info.component.scss'
})
export class CardAcountInfoComponent {
  user!: Userall;
  posts!: PostPlus[] | null;
  commonSub: UserInfo[] = [];
  errorMessage: string = '';

  constructor(private accountService: AccountService,) {
    this.user = this.accountService.userValue as Userall;
    console.log(this.user) // Add null check using the optional chaining operator
    this.posts = this.user?.posts as PostPlus[];
    console.log(this.posts) // Add null check using the optional chaining operator
    this.accountService.commonSub(this. user.id as number).subscribe({
      next: (response) => {
        if (response.success) {
            for (let i = 0; i < response.data.length; i++) {
              const usercommunsub: UserInfo = response.data[i];
              this.commonSub.push(usercommunsub);
          }
        } else {
          this.errorMessage = response.message;
        }
      },
      error: (err) => {
        this.errorMessage = 'An error occurred while fetching interests';
        console.error(err);
      }
    });
  }

  ngOnInit(): void {
    
  }
}
