import {User} from './user';
import {Account} from './account';

//define a user interface via the console
const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});
//initialize some users
let users = [
    new User('John', 'pass1'),
    new User('Sally', 'pass2'),
    new User('Mo', 'pass3')
]

//give them some money
users[0].accounts = [
    new Account(500, 'saving'),
    new Account(400, 'checking')
]

users[1].accounts = [
    new Account(700, 'saving'),
    new Account(900, 'checking')
]

users[2].accounts = [
    new Account(300, 'saving'),
    new Account(200, 'checking')
]

let username: string;
let password: string;
let loggedUser: User;
let option: string;
let amount: number

function getUsername(){
    rl.question("Please enter your username: ", (answer: string) => {
        username = answer;
        getPassword();
    })
}

function getPassword(){
    rl.question("Please enter your password: ", (answer: string) => {
        password = answer;
        login();
    })
}

function login(){
    loggedUser = users.filter((user: User) => user.login(username, password))[0];
    if(loggedUser){
        console.log("welcome to the bank");
        rl.question("Enter d for deposit, w for withdraw", (answer: string) =>{
            option = answer;
            if (option === 'd'){
                deposit();
            } else if (option === 'w'){
                withdraw();
            }
        })
    } else {
        console.log("please try again");
        getUsername();
    }
}

function deposit(){
    rl.question("Enter the amount you want to deposit", (answer: number) =>{
        amount = answer;
        loggedUser.getAccount(0).deposit(amount);
    })
}
function withdraw(){
    rl.question("Enter the amount you want to withdraw", (answer: number) =>{
        amount = answer;
        loggedUser.getAccount(0).withdraw(amount);
    })
}