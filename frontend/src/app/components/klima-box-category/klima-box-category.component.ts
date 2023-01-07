import {Component, EventEmitter, Input, OnInit, Output, SimpleChanges} from '@angular/core';
import { Klimabox } from 'src/app/models/Klimabox';
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
  klimaBox: Klimabox[];
  date: Date = new Date();

  constructor(private productService: ProductService) { }

  ngOnInit(): void {
    this.date = new Date(Date.now());
    this.initKlimaBox();
  }

  initKlimaBox() {
    this.productService.getAllKlimaBox().subscribe(p => this.klimaBox = p);
  }
}
