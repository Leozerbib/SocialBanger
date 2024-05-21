import { User } from '../User/user.model';
import { LocalDateTime } from 'js-joda';

export class Subscription {
    id: number;
    user: User;
    subscribedUser: User;
    createdAt: LocalDateTime;

    constructor(
        id: number,
        user: User,
        subscribedUser: User,
        createdAt: LocalDateTime
    ) {
        this.id = id;
        this.user = user;
        this.subscribedUser = subscribedUser;
        this.createdAt = createdAt;
    }
}
