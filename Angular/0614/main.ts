import {User} from './user';
import {account} from './account';

//Intialize some users 
let users =[
    new User('John','pass1'),
    new User('Kate','pass2'),
    new User('James','pass3')
]

//Define a new user interface via the console
const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
})


//Give em that paper
users[0].accounts = [
    new account(500,'checking'),
    new account(1000, 'savings' )
]

users[1].accounts = [
    new account(700,'checking'),
    new account(1000, 'savings' )
]

users[2].accounts = [
    new account(5100,'checking'),
    new account(1200, 'savings' )
]

let username : string;
let password : string;
let loggedUser: User;

getUsername();

function getUsername(){
    rl.question("Please enter username: ",(answer: string)=>{
        username = answer;
        getPassword();
    })
}

function getPassword(){
    rl.question("Please enter password: ",(answer: string)=>{
        password= answer;
        Login();
    })
}

function Login(){
    loggedUser = users.filter((user: User)=> user.login(username, password))[0];
    if(loggedUser){
        console.log("Welcome to the bank");
        printMenu(loggedUser);
    }else{
        console.log("Please try again");
        getUsername();
    }
}

let choice: string;
let loggedaccount: account;
let money: number;
let result: number;


function printMenu(loggedUser){
    console.log("Please choose from below your decision");
    console.log("1. Withdraw ");
    console.log("2. Deposit");
    rl.question("What would you like to do: \n", (answer: string)=>{
        choice = answer;
        if(choice === "1"){
            rl.question("Choose account for withdraw \n", (answer: number)=>{
                money = answer;
                loggedaccount = loggedUser.users.accounts.getAccount(account);
                console.log(loggedaccount);
            })
        }else if(choice ==="2"){
            console.log("Fine");
        }else{
            console.log("Okay wise guy lets try again ")
            printMenu(loggedUser);
        }
    })
}