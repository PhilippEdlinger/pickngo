import {Component, Input, OnInit} from '@angular/core';
import { Menu } from 'src/app/models/Menu';
import { Product } from 'src/app/models/Product';
import { MenuService } from 'src/app/services/menu.service';
import { ProductService } from 'src/app/services/product.service';
import {Observable} from "rxjs";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})

export class HomeComponent implements OnInit {
  menus: Menu[];
  @Input() products: Product;


  constructor(private menuService: MenuService, private productService: ProductService) { }

  ngOnInit(): void {
    this.initMenus();
  }

  initMenus(): void {
    this.menuService.getDishOfTheDay().subscribe(m => this.menus = m);
  }
}