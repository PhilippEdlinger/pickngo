import { Component, OnInit } from '@angular/core';
import { Order } from 'src/app/models/Order';
import { AdminPageService } from 'src/app/services/admin-page.service';
import { ProductService } from '../../services/product.service';

@Component({
  selector: 'app-admin-page',
  templateUrl: './admin-page.component.html',
  styleUrls: ['./admin-page.component.scss']
})
export class AdminPageComponent implements OnInit {
  orders: Order[];

  constructor(private productService: ProductService, private adminService: AdminPageService) { }

  ngOnInit(): void {
    this.adminService.currentOrder.subscribe(os => this.orders = os);
    console.log(this.orders);
  }
}
