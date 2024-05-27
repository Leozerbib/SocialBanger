
export class LikePlus {
  id: number;
  postId: number;
  createdAt: Date;

  constructor(id: number, postId: number, createdAt: Date) {
    this.id = id;
    this.postId = postId;
    this.createdAt = createdAt;
  }
}
