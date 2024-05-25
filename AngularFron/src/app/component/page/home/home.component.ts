import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { User } from '../../../model/User/user.model';
import { AccountService } from '../../../service/User/uer-service.service';
import { PostService } from '../../../service/Post/post.service';
import { Post } from '../../../model/Post/post.model';
import { UserDto } from '../../../model/User/user-dto.model';


@Component({ 
    selector: 'app-home',
    templateUrl: 'home.component.html',
    styleUrls: [
        'home.component.scss',
    ]
 })
export class HomeComponent implements OnInit{
    user: User | null;
    id!:any;
    posts: Post[] = [];
    userCommun: UserDto[] = [];
    errorMessage: string = '';
    
    constructor(private accountService: AccountService,private PostService: PostService) {
        this.user = this.accountService.userValue;
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
                    const user: UserDto = UserDto.fromJson(response.data[i]);
                    console.log(user);
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
    }
}