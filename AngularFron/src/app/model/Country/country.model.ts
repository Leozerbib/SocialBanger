export class Country {
    id: number;
    code: string;
    country: string;
    flag_image_url: string;

    constructor(id: number, code: string, country: string, flag_image_url: string) {
        this.id = id;
        this.code = code;
        this.country = country;
        this.flag_image_url = flag_image_url;
    }
}
