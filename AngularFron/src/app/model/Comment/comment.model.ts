import { User } from '../User/user.model';
import { Post } from '../Post/post.model';
import { LocalDateTime } from 'js-joda';
import { UserDto } from '../User/user-dto.model';

export class Comment {
    id: number;
    user: UserDto;
    content: string;
    createdAt: LocalDateTime;
    updatedAt: LocalDateTime;

    constructor(
        id: number,
        user: UserDto,
        content: string,
        createdAt: LocalDateTime,
        updatedAt: LocalDateTime
    ) {
        this.id = id;
        this.user = user;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static fromJson(json: any): Comment {
        return new Comment(
            json.id,
            UserDto.fromJson(json.user),
            json.content,
            LocalDateTime.parse(json.createdAt),
            LocalDateTime.parse(json.updatedAt)
        );
    }
}
