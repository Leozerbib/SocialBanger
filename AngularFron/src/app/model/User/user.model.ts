import { LocalDateTime } from 'js-joda';
import { Country } from '../Country/country.model';
import { Interest } from '../Interest/interest.model';
import { Subscription } from '../Subscription/subscription.model';
import { Post } from '../Post/post.model';
import { Gender } from '../enum/gender';
import { Status } from '../enum/status';

export class User {
    id: number;
    firstName: string;
    lastName: string;
    username: string;
    email: string;
    password: string;
    createdAt: LocalDateTime;
    updatedAt: LocalDateTime;
    userStatus: Status;
    age: number;
    gender: Gender;
    countSubscribers: number;
    countSubscriptions: number;
    interests: Set<Interest>;
    country: Country;
    subscriptions: Set<Subscription>;
    subscribers: Set<Subscription>;
    posts: Set<Post>;

    constructor(
        id: number,
        firstName: string,
        lastName: string,
        username: string,
        email: string,
        password: string,
        createdAt: LocalDateTime,
        updatedAt: LocalDateTime,
        userStatus: Status,
        age: number,
        gender: Gender,
        countSubscribers: number,
        countSubscriptions: number,
        interests: Set<Interest>,
        country: Country,
        subscriptions: Set<Subscription>,
        subscribers: Set<Subscription>,
        posts: Set<Post>
    ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.userStatus = userStatus;
        this.age = age;
        this.gender = gender;
        this.countSubscribers = countSubscribers;
        this.countSubscriptions = countSubscriptions;
        this.interests = interests;
        this.country = country;
        this.subscriptions = subscriptions;
        this.subscribers = subscribers;
        this.posts = posts;
    }
}
