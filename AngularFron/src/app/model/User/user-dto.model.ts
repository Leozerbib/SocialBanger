import { Status, booleanToStatus } from "../enum/status";

export class UserDto {

    id: number;
    username: string;
    userStatus: Status;

    constructor(id: number, username: string, userStatus: Status) {
        this.id = id;
        this.username = username;
        this.userStatus = userStatus;
    }

    public static fromJson(json: any): UserDto {
        return new UserDto(json.id, json.username, booleanToStatus(json.userStatus));
    }
}
