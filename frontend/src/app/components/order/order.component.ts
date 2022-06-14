import { Component, OnInit } from '@angular/core';
import { Order } from 'src/app/models/Order';
import { OrderItem } from 'src/app/models/OrderItem';
import { OrderDataService } from 'src/app/services/order-data.service';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.scss']
})
export class OrderComponent implements OnInit {
  order: Order;
  ordered = false;

  constructor(private orderData: OrderDataService) {}

  ngOnInit(): void {
    this.orderData.currentOrder.subscribe(o => this.order = o);
  }

  deleteOrderItem(orderItem: OrderItem): void {
    this.order.orderItems.splice(this.order.orderItems.findIndex(oi => oi.orderItemId.product.id === orderItem.orderItemId.product.id), 1);
    console.log(this.order);
    this.orderData.changeOrder(this.order);
  }
}
