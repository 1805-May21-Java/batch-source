"use strict";
exports.__esModule = true;
var account = /** @class */ (function () {
    function account(balance, type) {
        this.balance = balance;
        this.type = type;
    }
    account.prototype.withdraw = function (amount) {
        this.balance = this.balance - amount;
    };
    account.prototype.deposit = function (amount) {
        this.balance = this.balance + amount;
    };
    return account;
}());
exports.account = account;
