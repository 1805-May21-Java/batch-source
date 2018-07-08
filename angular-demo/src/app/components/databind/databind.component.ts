import { Component } from "@angular/core";

@Component({
    selector: 'app-databind',
    templateUrl: './databind.component.html'
})
export class DatabindComponent {

    person = {name:'Carolyn', email:'crehm@gmail.com'}

    name = 'Carolyn';

    email = 'crehm@gmail.com';

}