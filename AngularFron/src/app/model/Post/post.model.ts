import { User } from '../User/user.model';
import { Hashtag } from '../HashTag/hash-tag.model';
import { LocalDateTime } from 'js-joda';
import { Interest } from '../Interest/interest.model';
import { UserDto } from '../User/user-dto.model';
import { Comment } from '../Comment/comment.model';

export class Post {
    id: number;
    user: UserDto;
    img_url: string;
    content: string;
    createdAt: LocalDateTime;
    updatedAt: LocalDateTime;
    location: string;
    comments: Set<Comment>;
    countLikes: number;

    constructor(
        id: number,
        user: UserDto,
        img_url: string,
        content: string,
        createdAt: LocalDateTime,
        updatedAt: LocalDateTime,
        location: string,
        comments: Set<Comment> = new Set<Comment>(),
        countLikes: number
    ) {
        this.id = id;
        this.user = user;
        this.img_url = img_url;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.location = location;
        this.comments = comments;
        this.countLikes = countLikes;
    }

    public static responseToPost(response:any): Post {
        const Comments : Set<Comment> = new Set<Comment>();
        for (let comment of response.comments) {
            Comments.add(Comment.fromJson(comment));
        }
        return new Post(
            response.id,
            response.user,
            response.img_url,
            response.content,
            response.createdAt,
            response.updatedAt,
            response.location,
            Comments,
            response.countLikes
        );
    }
}
