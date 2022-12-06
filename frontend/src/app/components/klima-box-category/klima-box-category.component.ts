import {Component, EventEmitter, Input, OnInit, Output, SimpleChanges} from '@angular/core';
import { Product } from 'src/app/models/Product';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-klima-box-category',
  templateUrl: './klima-box-category.component.html',
  styleUrls: ['./klima-box-category.component.scss']
})
export class KlimaBoxCategoryComponent implements OnInit {
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
