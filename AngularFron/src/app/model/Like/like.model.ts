import { User } from '../User/user.model';
import { Post } from '../Post/post.model';
import { LocalDateTime } from 'js-joda';

export class Like {
    id: number;
    user: User;
    post: Post;
    createdAt: LocalDateTime;

    constructor(
        id: number,
        user: User,
        post: Post,
        createdAt: LocalDateTime
    ) {
        this.id = id;
        this.user = user;
        this.post = post;
        this.createdAt = createdAt;
    }
}
