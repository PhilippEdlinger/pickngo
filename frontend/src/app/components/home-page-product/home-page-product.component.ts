import { Component, OnInit, Input } from '@angular/core';
import { Order } from 'src/app/models/Order';
import { OrderItem } from 'src/app/models/OrderItem';
import { OrderItemID } from 'src/app/models/OrderItemID';
import { Product } from 'src/app/models/Product';
import { OrderDataService } from 'src/app/services/order-data.service';
import { environment } from "../../../environments/environment";

@Component({
  selector: 'app-home-page-product',
  templateUrl: './home-page-product.component.html',
  styleUrls: ['./home-page-product.component.scss']
})
export class HomePageProductComponent implements OnInit {
  @Input() product: Product;
  order: Order;
  bestellt: boolean = false;


  constructor(private orderData: OrderDataService) { }

  ngOnInit(): void {
    this.product.imageName = environment.apiUrl + '/product/img/' + this.product.imageName;
    this.orderData.currentOrder.subscribe(order => this.order = order);
  }



  onClick() {
    let yo = this.order.orderItems.find(oi2 => oi2.orderItemId.product.id === this.product.id);
    if (yo) {
      yo.quantity++;
    } else {
      let oi = new OrderItem();
      let oiId = new OrderItemID();
      oiId.product = this.product;
      oi.orderItemId = oiId;
      this.order.orderItems.push(oi);
    }

    this.orderData.changeOrder(this.order);

    this.bestellt = true;
    setTimeout(() => {
      this.bestellt = false;
    }, 3000);
  }
}
