export interface Person {
    id: Number,
    name: String,
    username: String,
    email: String,
    address: {
        street: string,
        suite: string,
        city: string,
        zipcode: string,
        geo:{
            lat: string,
            lng: string
        }
    },
    phone: string,
    wensite: string,
    company: {
        name: string,
        catchPhrase: string,
        bs: string
    }
}
