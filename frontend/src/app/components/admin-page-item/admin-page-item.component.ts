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
  @Input() buttonText: string;
  sum: number = 0;
  orderStats = {
    OPEN: 'Offen',
    IN_PRODUCTION: 'In Proktion',
    READY: 'Bereit',
    SPAM: 'Spam',
    CLOSED: 'Geschlossen'
  };

  constructor(private productService: ProductService, private orderService: OrderDataService, private adminService: AdminPageService) { }

  ngOnInit(): void {
    this.sum = 0;
    for (let oi of this.order.orderItems) {
      this.sum += oi.orderItemId.product.price * oi.quantity;
    }
  }

  finishOrder() {

    console.log(this.order);
    this.adminService.changeOrder(this.order);
  }

  onSelectChange(event: Event) {
    const e = event.currentTarget as HTMLSelectElement;
    this.order.orderStatus = e.value;
  }
}
