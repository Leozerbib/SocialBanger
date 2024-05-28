import { Component, Input, OnInit } from '@angular/core';
import { Userall } from '../../../../../model/User/userall.model';
import { AccountService } from '../../../../../service/User/uer-service.service';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { Observable } from 'rxjs';
import { switchMap } from 'rxjs/operators';
import { Post } from '../../../../../model/Post/post.model';
import { PostPlus } from '../../../../../model/Post/post-plus.model';

@Component({
  selector: 'app-card-profile-info',
  templateUrl: './card-profile-info.component.html',
  styleUrl: './card-profile-info.component.scss'
})
export class CardProfileInfoComponent implements OnInit{
    id!: number;
    user!:Userall;
    posts!: PostPlus[];
    errorMessage: string = '';
    ids!: string;

    constructor(private accountService: AccountService,private route: ActivatedRoute) {
      
    }
  
    

    ngOnInit(): void {
      console.log(this.route.paramMap);
      this.route.paramMap.subscribe((params: ParamMap) => {
        this.id = parseInt(params.get('id') as string);
      }); 
      console.log(this.id);
      this.accountService.getById(this.id).subscribe({
        next: (response) => {
          if (response.success) {
              this.user = response.data;
              console.log(this.user);
              this.posts = this.user.posts as PostPlus[];
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
}
