import {Component, HostListener, Input, OnInit} from '@angular/core';
import {Menu} from "../../models/Menu";
import {Product} from "../../models/Product";
import {MenuService} from "../../services/menu.service";
import {ProductService} from "../../services/product.service";

@Component({
  selector: 'app-green-box',
  templateUrl: './green-box.component.html',
  styleUrls: ['./green-box.component.scss']
})

export class GreenBoxComponent implements OnInit {
  menus: Menu[];
  @Input() products: Product;

  ngOnInit(): void {

  }

 /* @HostListener('window:scroll', ['$event']) // for window scroll events
  onScroll() {
    console.log("dff123");
    const element = document.querySelector("#section2")
    element?.scrollIntoView();
  }*/


  config: any;

  constructor(private menuService: MenuService, private productService: ProductService) {
  }

}

