import { Component, Input, OnInit } from '@angular/core';
import { Post } from '../../../../../model/Post/post.model';
import { PostPlus } from '../../../../../model/Post/post-plus.model';
import { Userall } from '../../../../../model/User/userall.model';

@Component({
  selector: 'app-card-publi-account',
  templateUrl: './card-publi-account.component.html',
  styleUrl: './card-publi-account.component.scss'
})
export class CardPubliAccountComponent implements OnInit{
  @Input() post!: PostPlus;
  @Input() user?: Userall ;
  countComents: number = 0;
  postt!: PostPlus;
  id: number = 0;
  username: string = 'oui';
  countInterests: number = 0;
  constructor() {

  }

  ngOnInit(): void {
    this.postt = this.post as PostPlus;
    console.log(this.postt);

    this.id = this.postt.user_id as number;
    this.username = this.user?.username as string;
  }

  isOpen = false;

  togglePanel() {
    this.isOpen = !this.isOpen;
  }

  comIsOpen = false;

  comPanel() {
    this.comIsOpen = !this.comIsOpen;
  }


  
}
