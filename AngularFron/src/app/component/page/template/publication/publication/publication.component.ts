import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CreatePost } from '../../../../../model/Post/create-post.model';
import { AccountService } from '../../../../../service/User/uer-service.service';
import { UserDto } from '../../../../../model/User/user-dto.model';

@Component({
  selector: 'app-publication',
  templateUrl: './publication.component.html',
  styleUrls: ['./publication.component.scss']
})
export class PublicationComponent {
  createPostForm: FormGroup;
  post!: CreatePost;
  user!: UserDto;

  constructor(private fb: FormBuilder,private accountService: AccountService) {
    this.createPostForm = this.fb.group({

      content: ['', Validators.required],
      imgUrl: ['']
    });
  }

  onSubmit() {
    if (this.createPostForm.valid) {
      this.post= this.createPostForm.value;
      
    }
  }
}

