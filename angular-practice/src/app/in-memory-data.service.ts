import { InMemoryDbService } from 'angular-in-memory-web-api';

export class InMemoryDataService implements InMemoryDbService {
  createDb() {
    const people = [
      {first: 'Banana', last: 'Smoothie', email: 'bananasmoothie@gmail.com', bday: new Date(1945, 3, 3)},
      {first: 'Cindy', last: 'Gorman', email: 'justgoingtobe@hotmail.com', bday: new Date(1985, 2, 25)},
      {first: 'This', last: 'Bird', email: 'bird123@gmail.com', bday: new Date(1990, 6, 28)}
    ];
    return {people};
  }
}