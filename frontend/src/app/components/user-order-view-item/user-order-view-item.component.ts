import { Component, Input, OnInit } from '@angular/core';
import { Order } from 'src/app/models/Order';

@Component({
  selector: 'app-user-order-view-item',
  templateUrl: './user-order-view-item.component.html',
  styleUrls: ['./user-order-view-item.component.scss']
})
export class UserOrderViewItemComponent implements OnInit {
  @Input() order: Order;
  @Input() orderNumber: number;
  status: string;
  orderStats = {
    OPEN: 'Offen',
    IN_PRODUCTION: 'In Proktion',
    READY: 'Bereit',
    SPAM: 'Spam',
    CLOSED: 'Geschlossen'
  };
  constructor() { }

  ngOnInit(): void {
    // console.log(this.orderStats[this.order.orderStatus]);

    let yo = Object.keys(this.orderStats).indexOf(this.order.orderStatus)

    this.status = Object.values(this.orderStats)[yo];   

    this.order.planedToPickTime = new Date(this.order.planedToPickTime)
    this.order.readyToPickTime = new Date(this.order.readyToPickTime)
  }

}
