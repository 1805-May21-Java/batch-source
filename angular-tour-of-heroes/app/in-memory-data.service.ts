import { InMemoryDbService } from 'angular-in-memory-web-api';

export class InMemoryDataService implements InMemoryDbService {
  createDb() {
    const heroes = [
        { id: 11, name: 'Lina' },
        { id: 12, name: 'Rylai the Crystal Maiden' },
        { id: 13, name: 'Lanaya the Templar Assassin' },
        { id: 14, name: 'Davian the Dragon Knight' },
        { id: 15, name: 'Lycanthrope' },
        { id: 16, name: 'IO the wisp' },
        { id: 17, name: 'Carl the Invoker' },
        { id: 18, name: 'Rubick' },
        { id: 19, name: 'Magnus' },
        { id: 20, name: 'Broodmother' }
    ];
    return {heroes};
  }
}