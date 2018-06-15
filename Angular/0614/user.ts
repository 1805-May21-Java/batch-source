import {account} from './account';

export class User{
    username: string;
    password: string;
    accounts: account[] = [];

    constructor(user: string, pass: string){
        this.username = user;
        this.password = pass;
    }

    login(user:string, pass: string):boolean{
        return this.username ===user && this.password === pass;
    }

    getAccount(index:number): account{
        return this.accounts[index];
    }
}