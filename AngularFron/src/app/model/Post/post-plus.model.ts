

export class PostPlus {
  id: number;
  userId: number;
  content: string;
  createdAt: Date;
  updatedAt: Date;
  location: string;
  imgUrl: string;
  likesCount: number;
  commentsCount: number;

  constructor(id: number, userId: number, content: string, createdAt: Date, updatedAt: Date, location: string, imgUrl: string, likesCount: number, commentsCount: number) {
    this.id = id;
    this.userId = userId;
    this.content = content;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.location = location;
    this.imgUrl = imgUrl;
    this.likesCount = likesCount;
    this.commentsCount = commentsCount;
  }
}
