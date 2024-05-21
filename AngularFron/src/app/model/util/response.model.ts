import { User } from "../User/user.model";

export class Response<T> {
    statusCode: number;
    message: string;
    success: boolean;
    data;

    constructor(statusCode: number, message: string, success: boolean, data : any | null) {
        this.statusCode = statusCode;
        this.message = message;
        this.success = success;
        this.data = data;
    }

    static failedResponse<T>(message: string, data: any): Response<T> {
        return new Response<T>(400, message, false, data);
    }

    static successfulResponse<T>(message: string, data : any): Response<T> {
        return new Response<T>(200, message, true, data);
    }
}
