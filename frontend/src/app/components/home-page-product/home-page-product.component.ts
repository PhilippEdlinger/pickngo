import { Component, OnInit, Input } from '@angular/core';
import { Product } from 'src/app/models/Product';

@Component({
  selector: 'app-home-page-product',
  templateUrl: './home-page-product.component.html',
  styleUrls: ['./home-page-product.component.scss']
})
export class HomePageProductComponent{
  @Input() product: Product;

  constructor() { }

}
