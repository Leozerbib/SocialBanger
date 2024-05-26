import { Country } from "../Country/country.model";
import { Interest } from "../Interest/interest.model";
import { Status, booleanToStatus } from "../enum/status";

export class UserInfo {
    id: number;
    username: string;
    userStatus: Status;
    count_subscribers: number;
    count_subscriptions: number;
    country: Country;
    interest: Interest[];


    constructor(id: number, username: string, userStatus: Status, count_subscribers: number, count_subscriptions: number, country: Country, interest: Interest[]) {
        this.id = id;
        this.username = username;
        this.userStatus = userStatus;
        this.count_subscribers = count_subscribers;
        this.count_subscriptions = count_subscriptions;
        this.country = country;
        this.interest = interest;
    }

    public static fromJson(json: any): UserInfo {
        return new UserInfo(json.id, json.username, booleanToStatus(json.userStatus), json.count_subscribers, json.count_subscriptions, json.country, json.interest);
    }
}
