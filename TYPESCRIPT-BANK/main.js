"use strict";
exports.__esModule = true;
var user_1 = require("./user");
var account_1 = require("./account");
//define a user interface via the console
var readline = require('readline');
var rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});
//initialize some users
var users = [
    new user_1.User('John', 'pass1'),
    new user_1.User('Sally', 'pass2'),
    new user_1.User('Mo', 'pass3')
];
//give them some money
users[0].accounts = [
    new account_1.Account(500, 'saving'),
    new account_1.Account(400, 'checking')
];
users[1].accounts = [
    new account_1.Account(700, 'saving'),
    new account_1.Account(900, 'checking')
];
users[2].accounts = [
    new account_1.Account(300, 'saving'),
    new account_1.Account(200, 'checking')
];
var username;
var password;
var loggedUser;
function getUsername() {
    rl.question("Please enter your username: ", function (answer) {
        username = answer;
        getPassword();
    });
}
function getPassword() {
    rl.question("Please enter your password: ", function (answer) {
        password = answer;
        login();
    });
}
function login() {
    loggedUser = users.filter(function (user) { return user.login(username, password); })[0];
    if (loggedUser) {
        console.log("welcome to the bank");
    }
    else {
        console.log("please try again");
        getUsername();
    }
}
