import { Component, Input, OnInit } from '@angular/core';
import { Product } from 'src/app/models/Product';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-product-category',
  templateUrl: './product-category.component.html',
  styleUrls: ['./product-category.component.scss']
})
export class ProductCategoryComponent implements OnInit {
  @Input() title: String;
  @Input() urlName: String;
  products: Product[];

  constructor(private productService: ProductService) { }

  ngOnInit(): void {
      this.initProducts();
  }

  initProducts() {
    this.productService.getProductCategory(this.urlName).subscribe(p => this.products = p);
  }
}
