import { Component, Input, OnInit} from '@angular/core';
import { Order } from 'src/app/models/Order';

@Component({
  selector: 'app-admin-page-item',
  templateUrl: './admin-page-item.component.html',
  styleUrls: ['./admin-page-item.component.scss']
})
export class AdminPageItemComponent implements OnInit {
  @Input() order: Order;

  constructor() { }
  ngOnInit(): void {
    console.log(this.order);
  }

  finishOrder() {
    console.log("Order finished");
  }
}
