import { InMemoryDbService } from 'angular-in-memory-web-api';

export class InMemoryDataService implements InMemoryDbService {
  createDb() {
    const heroes = [
      { id: 1, name: 'All-Might'},
      { id: 2, name: 'Flaming Fero'},
      { id: 3, name: 'Knockout Kenny'},
      { id: 4, name: 'Trap King Jeffery'},
      { id: 5, name: 'LookoGuy'},
      { id: 6, name: 'Mr.Nail'},
      { id: 7, name: 'Superman'},
      { id: 8, name: 'Pikachu'},
      { id: 9, name: 'Orange Power'},
      { id: 10, name: 'Puck'},
      { id: 11, name: 'Mr. Nice' },
      { id: 12, name: 'Narco' },
      { id: 13, name: 'Bombasto' },
      { id: 14, name: 'Celeritas' },
      { id: 15, name: 'Magneta' },
      { id: 16, name: 'RubberMan' },
      { id: 17, name: 'Dynama' },
      { id: 18, name: 'Dr IQ' },
      { id: 19, name: 'Magma' },
      { id: 20, name: 'Tornado' }
    ];
    return {heroes};
  }
}
