import {Account} from './account';

export class User{
    username: String;
    password: String;
    accounts: Account[] = [];

    constructor (user: String, pass: String){
        this.username = user;
        this.password = pass;
    }

    login(user: string, pass: string): boolean{
        return this.username === user && this.password === pass;
    }

    getAccount(index: number): Account{
        return this.accounts[index];
    }
}