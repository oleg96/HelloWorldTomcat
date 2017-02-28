"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
Object.defineProperty(exports, "__esModule", { value: true });
var core_1 = require("@angular/core");
var user_1 = require("./user");
var log_service_1 = require("./log.service.ts");
var UserService = (function () {
    function UserService(logService) {
        this.logService = logService;
        this.users = [];
    }
    UserService.prototype.getUsers = function () {
        var _this = this;
        this.logService.write("Get users from service");
        this.users.length = 0;
        fetch('http://localhost:8080/HelloWorldTomcat/service/users')
            .then(function (responce) { return responce.json(); })
            .then(function (users) {
            for (var index = 0; index < users.length; index++) {
                _this.users.push(new user_1.User(users[index].id, users[index].name));
            }
        })
            .catch(function (error) {
            _this.logService.write('Request failed: ' + error);
        });
        return this.users;
    };
    UserService.prototype.addUser = function (id, name) {
        this.users.push(new user_1.User(id, name));
        this.logService.write("Added user: " + id + " " + name);
    };
    return UserService;
}());
UserService = __decorate([
    core_1.Injectable(),
    __metadata("design:paramtypes", [log_service_1.LogService])
], UserService);
exports.UserService = UserService;
//# sourceMappingURL=user.service.js.map