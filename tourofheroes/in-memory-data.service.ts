import { InMemoryDbService } from 'angular-in-memory-web-api';

export class InMemoryDataService implements InMemoryDbService {
  createDb() {
    const heroes = [
        {id: 11, name: 'Sailor Moon'},
        {id: 12, name: 'Sailor Mars'},
        {id: 13, name: 'Sailor Mercury'},
        {id: 14, name: 'Sailor Jupiter'},
        {id: 15, name: 'Sailor Venus'},
        {id: 16, name: 'Sailor Pluto'},
        {id: 17, name: 'Sailor Neptune'},
        {id: 18, name: 'Sailor Uranus'},
        {id: 19, name: 'Sailor Saturn'},
    ];
    return {heroes};
  }
}