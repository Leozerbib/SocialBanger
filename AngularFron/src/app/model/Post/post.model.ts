import { User } from '../User/user.model';
import { Hashtag } from '../HashTag/hash-tag.model';
import { LocalDateTime } from 'js-joda';

export class Post {
    id: number;
    user: User;
    content: string;
    createdAt: LocalDateTime;
    updatedAt: LocalDateTime;
    location: string;
    hashtags: Set<Hashtag>;

    constructor(
        id: number,
        user: User,
        content: string,
        createdAt: LocalDateTime,
        updatedAt: LocalDateTime,
        location: string,
        hashtags: Set<Hashtag> = new Set<Hashtag>()
    ) {
        this.id = id;
        this.user = user;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.location = location;
        this.hashtags = hashtags;
    }
}
