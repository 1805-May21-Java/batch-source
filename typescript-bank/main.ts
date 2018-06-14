import {User} from './user';
import {Account} from './account';

//define a user interface via the console
const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
})

//initialize some users
let users = [
    new User('John','pass1'),
    new User('Sally', 'pass2'),
    new User('Mo','pass3')
]

//give them some money
users[0].accounts = [
    new Account(500, 'savings'),
    new Account(400, 'checking')
]

users[1].accounts = [
    new Account(700, 'savings'),
    new Account(900, 'checking')
]

users[2].accounts = [
    new Account(300, 'savings'),
    new Account(200, 'checking')
]

let username : string;
let password : string;

let loggedUser: User;

getUsername();

function getUsername(){
    rl.question("Please enter username: ", (answer: string)=>{
        username = answer;
        getPassword();
    })
}

function getPassword(){
    rl.question("Please enter password: ", (answer: string)=>{
        password = answer;
        login();
    })

}

function login(){
    loggedUser = users.filter((user: User)=> user.login(username, password))[0];
    if (loggedUser){
        console.log("welcome to the bank");
    } else {
        console.log("please try again");
        getUsername();
    }

}
