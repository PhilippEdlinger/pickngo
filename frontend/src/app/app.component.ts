import { Component } from '@angular/core';
import { Order } from './models/Order';
import { Product } from './models/Product';
import { OrderItem } from './models/OrderItem';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'pickngo-angular';
  hide: boolean = true;
  order: Order = new Order();

  hideShoppC() {
    this.hide = !this.hide;
  }

  addProduct(products: Product[]): void {
    for (let p of products) {
      let oi = new OrderItem();
      oi.orderItemId.product = p;
      this.order.orderItems.push(oi);
    }
    console.log(this.order);
  }
}
