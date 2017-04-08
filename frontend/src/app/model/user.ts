import {Authority} from "./authority";
export class User {
    id: number;
    name: string;
    password: string;
    authorities: Authority[];
    token: string;

    constructor(name: string, password: string) {
        this.name = name;
        this.password = password;
    }
}
