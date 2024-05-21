import { Post } from '../Post/post.model';

export class Hashtag {
    id: number;
    name: string;
    posts: Set<Post>;

    constructor(id: number, name: string, posts: Set<Post> = new Set<Post>()) {
        this.id = id;
        this.name = name;
        this.posts = posts;
    }
}
