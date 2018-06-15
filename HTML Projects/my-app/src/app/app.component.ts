import { Component } from '@angular/core';

@Component({
  selector: 'app-root', // CSS element selector
  templateUrl: './app.component.html', // location of the component's template file
  styleUrls: ['./app.component.css'] // location of the component's private CSS styles
})
export class AppComponent {
  title = 'Tour of Heroes';
}
