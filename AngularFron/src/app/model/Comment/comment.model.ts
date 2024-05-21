import { User } from '../User/user.model';
import { Post } from '../Post/post.model';
import { LocalDateTime } from 'js-joda';

export class Comment {
    id: number;
    user: User;
    post: Post;
    content: string;
    createdAt: LocalDateTime;
    updatedAt: LocalDateTime;

    constructor(
        id: number,
        user: User,
        post: Post,
        content: string,
        createdAt: LocalDateTime,
        updatedAt: LocalDateTime
    ) {
        this.id = id;
        this.user = user;
        this.post = post;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
