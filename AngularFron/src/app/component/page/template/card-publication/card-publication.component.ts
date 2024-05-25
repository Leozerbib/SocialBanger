import { Component, Input, OnInit } from '@angular/core';
import { CardModule } from 'primeng/card';
import { ButtonModule } from 'primeng/button';
import { Post } from '../../../../model/Post/post.model';


@Component({
  selector: 'app-card-publication',
  templateUrl: './card-publication.component.html',
  styleUrl: './card-publication.component.scss'
})
export class CardPublicationComponent implements OnInit{
  @Input() post!: Post;
  countComents: number = 0;
  countInterests: number = 0;
  constructor() {

  }

  ngOnInit(): void {
    for (let comment of this.post.comments) {
      this.countComents++;
    }
    for (let interest of this.post.interests) {
      this.countInterests++;
    }
    console.log(this.countComents);
  }

  isOpen = false;

  togglePanel() {
    this.isOpen = !this.isOpen;
  }

  comIsOpen = false;

  comPanel() {
    this.comIsOpen = !this.comIsOpen;
  }

  liked() {
    if (this.post.countLikes == 0) {
      this.post.countLikes = 1;
    }
  }

  

}
