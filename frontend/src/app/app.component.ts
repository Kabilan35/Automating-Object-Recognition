import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';
}

// @Component({
//   selector: 'app-root',
//   template: `<h4>Directives</h4>
//   <ul *ngFor="let code of codes>
//   <li [ngStyle]="{'color':code)}">{{code}}</li>
//   </ul>
//   `,
//   styleUrls: ['./app.component.css']
// })
// export class AppComponent {
//   codes=["blue","green","red"]
// }
