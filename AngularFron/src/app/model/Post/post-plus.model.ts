

export class PostPlus {
  id: number;
  user_id: number;
  content: string;
  createdAt: Date;
  updatedAt: Date;
  location: string;
  img_url: string;
  likesCount: number;
  commentsCount: number;

  constructor(id: number, user_id: number, content: string, createdAt: Date, updatedAt: Date, location: string, img_url: string, likesCount: number, commentsCount: number) {
    this.id = id;
    this.user_id = user_id;
    this.content = content;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.location = location;
    this.img_url = img_url;
    this.likesCount = likesCount;
    this.commentsCount = commentsCount;
  }
}
