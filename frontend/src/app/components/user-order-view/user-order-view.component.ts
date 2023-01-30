import { Component, OnInit } from '@angular/core';
import { Order } from 'src/app/models/Order';
import { OrderDataService } from 'src/app/services/order-data.service';

@Component({
  selector: 'app-user-order-view',
  templateUrl: './user-order-view.component.html',
  styleUrls: ['./user-order-view.component.scss']
})
export class UserOrderViewComponent implements OnInit {
  orders: Order[];
  userId: number = 3;

  constructor(private service: OrderDataService) { }

  ngOnInit(): void {
    this.service.getUserOrders(this.userId).subscribe(os => this.orders = os);
  }

}
