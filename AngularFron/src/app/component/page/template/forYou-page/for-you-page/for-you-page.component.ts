import { Component, OnInit } from '@angular/core';
import { PostPlus } from '../../../../../model/Post/post-plus.model';
import { PostService } from '../../../../../service/Post/post.service';
import { AccountService } from '../../../../../service/User/uer-service.service';
import { Userall } from '../../../../../model/User/userall.model';

@Component({
  selector: 'app-for-you-page',
  templateUrl: './for-you-page.component.html',
  styleUrl: './for-you-page.component.scss'
})
export class ForYouPageComponent implements OnInit{
  posts: PostPlus[] = [];
  id!: number;
  constructor(private postService: PostService,private accountService: AccountService) {
  }

  ngOnInit(): void {
    this.id = this.accountService.userValue?.id as number;
    this.postService.getAllPostLikeInterest(this.id).subscribe({
      next: (response) => {
        if (response.success) {
            console.log(response.data);
            for (let i = 0; i < response.data.length; i++) {
              const post: PostPlus = response.data[i];
              console.log(post);
              this.posts.push(post);
            console.log(this.posts);
            }
        } else {
          console.error(response.message);
        }
      },
      error: (err) => {
        console.error(err);
      }
    });
  }

}
