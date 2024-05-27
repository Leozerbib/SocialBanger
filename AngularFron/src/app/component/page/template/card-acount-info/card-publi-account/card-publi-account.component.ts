import { Component, Input } from '@angular/core';
import { Post } from '../../../../../model/Post/post.model';
import { PostPlus } from '../../../../../model/Post/post-plus.model';
import { Userall } from '../../../../../model/User/userall.model';

@Component({
  selector: 'app-card-publi-account',
  templateUrl: './card-publi-account.component.html',
  styleUrl: './card-publi-account.component.scss'
})
export class CardPubliAccountComponent {
  @Input() post!: PostPlus;
  @Input() user!: Userall | null;
  countComents: number = 0;
  username: string = 'oui';
  countInterests: number = 0;
  constructor() {
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
