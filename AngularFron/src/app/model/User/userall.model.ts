import { Country } from "../Country/country.model";
import { Interest } from "../Interest/interest.model";
import { LikePlus } from "../Like/like-plus.model";
import { PostPlus } from "../Post/post-plus.model";
import { SubscriptionPlus } from "../Sub/subscription-plus.model";
import { Gender } from "../enum/gender";
import { Status } from "../enum/status";

export class Userall {

  id: number;
  firstName: string;
  lastName: string;
  username: string;
  email: string;
  password: string;
  createdAt: Date;
  updatedAt: Date;
  userStatus: Status;
  age: number;
  gender: Gender;
  interests: Interest[];
  country: Country;
  countSubscribers: number;
  countSubscriptions: number;
  subscriptions: SubscriptionPlus[];
  posts: PostPlus[];
  likes: LikePlus[];

  constructor(id: number, firstName: string, lastName: string, username: string, email: string, password: string, createdAt: Date, updatedAt: Date, userStatus: Status, age: number, gender: Gender, interests: Interest[], country: Country, countSubscribers: number, countSubscriptions: number, subscriptions: SubscriptionPlus[], posts: PostPlus[], likes: LikePlus[]) {
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

