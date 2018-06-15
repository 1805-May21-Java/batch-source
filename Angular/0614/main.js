"use strict";
exports.__esModule = true;
var user_1 = require("./user");
var account_1 = require("./account");
//Intialize some users 
var users = [
    new user_1.User('John', 'pass1'),
    new user_1.User('Kate', 'pass2'),
    new user_1.User('James', 'pass3')
];
//Define a new user interface via the console
var readline = require('readline');
var rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});
//Give em that paper
users[0].accounts = [
    new account_1.account(500, 'checking'),
    new account_1.account(1000, 'savings')
];
users[1].accounts = [
    new account_1.account(700, 'checking'),
    new account_1.account(1000, 'savings')
];
users[2].accounts = [
    new account_1.account(5100, 'checking'),
    new account_1.account(1200, 'savings')
];
var username;
var password;
var loggedUser;
getUsername();
function getUsername() {
    rl.question("Please enter username: ", function (answer) {
        username = answer;
        getPassword();
    });
}
function getPassword() {
    rl.question("Please enter password: ", function (answer) {
        password = answer;
        Login();
    });
}
function Login() {
    loggedUser = users.filter(function (user) { return user.login(username, password); })[0];
    if (loggedUser) {
        console.log("Welcome to the bank");
        printMenu(loggedUser);
    }
    else {
        console.log("Please try again");
        getUsername();
    }
}
var choice;
var loggedaccount;
var money;
var result;
function printMenu(loggedUser) {
    console.log("Please choose from below your decision");
    console.log("1. Withdraw ");
    console.log("2. Deposit");
    rl.question("What would you like to do: \n", function (answer) {
        choice = answer;
        if (choice === "1") {
            rl.question("Choose account for withdraw \n", function (answer) {
                money = answer;
                loggedaccount = loggedUser.users.accounts.getAccount(account_1.account);
                console.log(loggedaccount);
            });
        }
        else if (choice === "2") {
            console.log("Fine");
        }
        else {
            console.log("Okay wise guy lets try again ");
            printMenu(loggedUser);
        }
    });
}
