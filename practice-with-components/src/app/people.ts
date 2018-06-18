export class People
{
    firstName: string;
    lastName: string;
    email: string;
    birthday: Date;

    constructor(firstName: string, lastName: string, email: string, birthday: Date)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthday = birthday;
    }
}
