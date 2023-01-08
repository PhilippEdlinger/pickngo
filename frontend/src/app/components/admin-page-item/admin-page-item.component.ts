import { Component, Input, OnInit } from '@angular/core';
import { Order } from 'src/app/models/Order';
import { ProductService } from "../../services/product.service";
import { OrderDataService } from "../../services/order-data.service";
import { AdminPageService } from 'src/app/services/admin-page.service';

@Component({
  selector: 'app-admin-page-item',
  templateUrl: './admin-page-item.component.html',
  styleUrls: ['./admin-page-item.component.scss']
})
export class AdminPageItemComponent implements OnInit {
  @Input() order: Order;
  sum: number = 0;

  constructor(private productService: ProductService, private orderService: OrderDataService, private adminService: AdminPageService) { }

  ngOnInit(): void {
    this.sum = 0;
    for (let oi of this.order.orderItems) {
      this.sum += oi.orderItemId.product.price * oi.quantity;
    }
  }

  finishOrder() {
    console.log("Order finished");
    this.adminService.close(this.order.id);
  }
}
