import { Country } from "../Country/country.model";
import { Interest } from "../Interest/interest.model";
import { LikePlus } from "../Like/like-plus.model";
import { PostPlus } from "../Post/post-plus.model";
import { SubscriptionPlus } from "../Sub/subscription-plus.model";
import { Gender } from "../enum/gender";
import { Status } from "../enum/status";

export class Userall {

  id: number | undefined;
  firstName: string | undefined;
  lastName: string | undefined;
  username: string | undefined;
  email: string | undefined;
  password: string | undefined;
  createdAt: Date | undefined;
  updatedAt: Date | undefined;
  userStatus: Status | undefined;
  age: number | undefined;
  gender: Gender | undefined;
  interests: Interest[] | undefined;
  country: Country | undefined;
  countSubscribers: number | undefined;
  countSubscriptions: number | undefined;
  subscriptions: SubscriptionPlus[] | undefined;
  posts: PostPlus[] | undefined;
  likes: LikePlus[] | undefined;


  constructor(id?: number, firstName?: string, lastName?: string, username?: string, email?: string, password?: string, createdAt?: Date, updatedAt?: Date, userStatus?: Status, age?: number, gender?: Gender, interests?: Interest[], country?: Country, countSubscribers?: number, countSubscriptions?: number, subscriptions?: SubscriptionPlus[], posts?: PostPlus[], likes?: LikePlus[]) {
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
    this.interests = interests;
    this.country = country;
    this.countSubscribers = countSubscribers;
    this.countSubscriptions = countSubscriptions;
    this.subscriptions = subscriptions;
    this.posts = posts;
    this.likes = likes;
  }
}

