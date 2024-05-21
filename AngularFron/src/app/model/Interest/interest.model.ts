export class Interest {
    id: number;
    category: string;
    subcategory: string;

    constructor(id: number, category: string, subcategory: string) {
        this.id = id;
        this.category = category;
        this.subcategory = subcategory;
    }
}
