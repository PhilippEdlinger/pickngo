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

  imageObject: Array<object> = [{
    image: 'assets/img/schnitzel.jpg',
    thumbImage: 'assets/img/schnitzel.jpg',
    alt: 'alt of image',
    title: 'title of image'
  }, {
    image: 'assets/img/products/backhendl.jpg', // Support base64 image
    thumbImage: 'assets/img/products/backhendl.jpg', // Support base64 image
    title: 'Image title', //Optional: You can use this key if want to show image with title
    alt: 'Image alt', //Optional: You can use this key if want to show image with alt
  }, {
    image: 'assets/img/products/schweinsbraten.jpg', // Support base64 image
    thumbImage: 'assets/img/products/schweinsbraten.jpg', // Support base64 image
    title: 'Image title', //Optional: You can use this key if want to show image with title
    alt: 'Image alt', //Optional: You can use this key if want to show image with alt
  }, {
    image: 'assets/img/products/rehbraten.jpg', // Support base64 image
    thumbImage: 'assets/img/products/rehbraten.jpg', // Support base64 image
    title: 'Image title', //Optional: You can use this key if want to show image with title
    alt: 'Image alt', //Optional: You can use this key if want to show image with alt
  }
  ];

  initMenus(): void {
    this.menuService.getDishOfTheDay().subscribe(m => this.menus = m);
  }
}