import { Component, OnInit, Input } from '@angular/core';
import { Menu } from 'src/app/models/Menu';

@Component({
  selector: 'app-product-menu',
  templateUrl: './product-menu.component.html',
  styleUrls: ['./product-menu.component.scss']
})
export class ProductMenuComponent implements OnInit {
  @Input() menu: Menu;
  @Input() name: String;
  title: String = '';
  constructor() { }

  ngOnInit(): void {
    const p = this.menu.products;
      for (let i = 0; i < p.length - 2; i++) {
        this.title += p[i].name + ', ';
      }
      this.title += p[p.length - 2].name + ' und ' + p[p.length - 1].name + '';
  }
}
