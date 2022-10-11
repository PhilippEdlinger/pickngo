import { Component, OnInit } from '@angular/core';
import { Order } from 'src/app/models/Order';
import { ProductService } from '../../services/product.service';

@Component({
  selector: 'app-admin-page',
  templateUrl: './admin-page.component.html',
  styleUrls: ['./admin-page.component.scss']
})
export class AdminPageComponent implements OnInit {
  orders: Order[];

  constructor(private productService: ProductService) { }

  ngOnInit(): void {
    this.productService.getAllOrder().subscribe(os => {this.orders = os; console.log(os)});
    console.log(this.orders);
  }

}
