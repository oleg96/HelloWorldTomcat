import "rxjs/add/operator/map";
import {User} from "../model/user";

export class AuthorityComponent {

    public static getCurrentUser() {
        return JSON.parse(localStorage.getItem('currentUser'));
    }

    public canWorkWithAdminPanel(): boolean {
        return AuthorityComponent.canAccessComponent("ROLE_ADMIN");
    }

    static canAccessComponent(authority: string): boolean {
        let user: User = AuthorityComponent.getCurrentUser();
        if (user != null)
            for (let currentAuthority of user.authorities) {
                if (currentAuthority.name === authority)
                    return true;
            }
        return false;
    }
}