// create-post-dto.model.ts

import { UserDto } from "../User/user-dto.model";

  
  export class CreatePost {
    user: UserDto | null;
    content: string;
    imgUrl: string;
  
    constructor(user?: UserDto, content?: string, imgUrl?: string) {
      this.user = user || null;
      this.content = content || '';
      this.imgUrl = imgUrl || '';
    }
  }
  