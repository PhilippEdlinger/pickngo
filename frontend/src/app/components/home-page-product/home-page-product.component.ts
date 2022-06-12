import { Component, OnInit, Input } from '@angular/core';
import { Product } from 'src/app/models/Product';

@Component({
  selector: 'app-home-page-product',
  templateUrl: './home-page-product.component.html',
  styleUrls: ['./home-page-product.component.scss']
})
export class HomePageProductComponent implements OnInit{
  @Input() product: Product;

  constructor() { }

  ngOnInit(): void {
      this.product.imageName = 'http://localhost:8080/product/img/' + this.product.imageName;
  }
}
