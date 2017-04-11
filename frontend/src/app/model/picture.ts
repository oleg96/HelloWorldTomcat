export class Picture {
    id: number;
    author: string;
    name: string;
    description: string;
    owner: string;
    tags: string;
    image: string;

    constructor(id: number, author: string, name: string, description: string, owner: string, tags: string, image: string) {
        this.id = id;
        this.author = author;
        this.name = name;
        this.description = description;
        this.owner = owner;
        this.tags = tags;
        this.image = image;
    }
}