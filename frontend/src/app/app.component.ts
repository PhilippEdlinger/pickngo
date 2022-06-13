import { Component } from '@angular/core';
import { Menu } from './models/Menu';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'pickngo-angular';
  hide: boolean = true;
  menu: Menu;

  hideShoppC() {
    this.hide = !this.hide;
  }
}
