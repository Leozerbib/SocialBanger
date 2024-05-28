import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { User } from '../../../model/User/user.model';
import { AccountService } from '../../../service/User/uer-service.service';
import { PostService } from '../../../service/Post/post.service';
import { Post } from '../../../model/Post/post.model';
import { UserDto } from '../../../model/User/user-dto.model';
import { UserInfo } from '../../../model/User/user-info.class';
import { Userall } from '../../../model/User/userall.model';
import { Subscription } from '../../../model/Subscription/subscription.model';
import { SubscriptionSub } from '../../../model/Sub/subscription-sub.model';


@Component({ 
    selector: 'app-home',
    templateUrl: 'home.component.html',
    styleUrls: [
        'home.component.scss',
    ]
 })
export class HomeComponent implements OnInit{
    user: Userall;
    id!:any;
    posts: Post[] = [];
    userCommun: UserInfo[] = [];
    userCommunSub: UserInfo[] = [];
    userSub: UserDto[] = [];
    errorMessage: string = '';
    isConnected: boolean = false;
    
    constructor(private accountService: AccountService,private PostService: PostService) {
        this.user = this.accountService.userValue as Userall;
        console.log(this.user);
    }

    ngOnInit(): void {
        this.id = this.accountService.userValue?.id as number;
        this.PostService.getAllPostSub(this.id).subscribe({
            next: (response) => {
              if (response.success) {
                  for (let i = 0; i < response.data.length; i++) {
                    const intereste: Post = response.data[i];
                    this.posts.push(intereste);
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
        this.accountService.communInterest(this.id).subscribe({
            next: (response) => {
              if (response.success) {
                  for (let i = 0; i < response.data.length; i++) {
                    const user: UserInfo = UserInfo.fromJson(response.data[i]);
                    this.userCommun.push(user);
                }
              } else {
                this.errorMessage = response.message;
                console.log(response.message);
              }
              console.log(this.userCommun[0].userStatus);
              
            },
            error: (err) => {
              this.errorMessage = 'An error occurred while fetching interests';
              console.error(err);
            }
          });
          this.accountService.communSub(this.id).subscribe({
            next: (response) => {
              if (response.success) {
                  for (let i = 0; i < response.data.length; i++) {
                    const user: UserInfo = UserInfo.fromJson(response.data[i]);
                    this.userCommunSub.push(user);
                  
                }
              } else {
                this.errorMessage = response.message;
                console.log(response.message);
              }
              
            },
            error: (err) => {
              this.errorMessage = 'An error occurred while fetching interests';
              console.error(err);
            }
          });
          this.accountService.Sub(this.id).subscribe({
            next: (response) => {
              if (response.success) {
                  for (let i = 0; i < response.data.length; i++) {
                    const user: SubscriptionSub = SubscriptionSub.fromDto(response.data[i]);
                    const users: UserDto = UserDto.fromJson(user.subscribedUser);
                    this.userSub.push(users);
                }
              } else {
                this.errorMessage = response.message;
                console.log(response.message);
              }
              
            },
            error: (err) => {
              this.errorMessage = 'An error occurred while fetching interests';
              console.error(err);
            }
          });
    }
}