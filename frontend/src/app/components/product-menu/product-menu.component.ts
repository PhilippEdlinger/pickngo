import { Component, OnInit, Input } from '@angular/core';
import { Menu } from 'src/app/models/Menu';

@Component({
  selector: 'app-product-menu',
  templateUrl: './product-menu.component.html',
  styleUrls: ['./product-menu.component.scss']
})
export class ProductMenuComponent {
  @Input() menu: Menu;
  constructor() { }
}
