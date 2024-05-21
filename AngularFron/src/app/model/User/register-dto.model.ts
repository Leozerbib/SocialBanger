import { Country } from '../Country/country.model';
import { Interest } from '../Interest/interest.model';

export class RegisterDto {
    firstName: string;
    lastName: string;
    username: string;
    email: string;
    password: string;
    age: number;
    gender: string;
    interests: Set<Interest>;
    country: Country;

    constructor(
        firstName: string,
        lastName: string,
        username: string,
        email: string,
        password: string,
        age: number,
        gender: string,
        interests: Set<Interest>,
        country: Country
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.age = age;
        this.gender = gender;
        this.interests = interests;
        this.country = country;
    }
}
