import { UserDto } from '../User/user-dto.model';
import { User } from '../User/user.model';
import { LocalDateTime } from 'js-joda';

export class SubscriptionSub {

    id: number;
    user: UserDto;
    subscribedUser: UserDto;
    createdAt: LocalDateTime;

    constructor(
        id: number,
        user: UserDto,
        subscribedUser: UserDto,
        createdAt: LocalDateTime
    ) {
        this.id = id;
        this.user = user;
        this.subscribedUser = subscribedUser;
        this.createdAt = createdAt;
    }

    static fromDto(json: any): SubscriptionSub {
        return new SubscriptionSub(
            json.id,
            UserDto.fromJson(json.user),
            UserDto.fromJson(json.subscribedUser),
            json.createdAt
        );
    }
}
