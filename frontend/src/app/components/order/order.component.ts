import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Order } from 'src/app/models/Order';
import { OrderItem } from 'src/app/models/OrderItem';
import { User } from 'src/app/models/User';
import { ApiService } from 'src/app/services/api.service';
import { OrderDataService } from 'src/app/services/order-data.service';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.scss']
})
export class OrderComponent implements OnInit {
  order: Order;
  orderCopy: Order;
  ordered = false;
  form: FormGroup;
  logedIn: boolean = false;
  user: any;
  bestellt: boolean = false;
  sum: number = 0;

  constructor(private orderData: OrderDataService, private fb: FormBuilder, private productService: ProductService, private ls: ApiService) {
    this.form = this.fb.group({
      tele: [null, Validators.required, Validators.minLength(7), Validators.maxLength(20)]
    });
  }

  ngOnInit(): void {
    this.bestellt = false;
    this.orderData.currentOrder.subscribe(o => {
      this.order = o;
      this.sum = 0;
      for (let oi of o.orderItems) {
        this.sum += oi.orderItemId.product.price * oi.quantity;
      }
    });
    this.orderCopy = this.order;
    console.log(this.order);
    // this.order = new Order();
    console.log(this.orderCopy);
    this.ls.user.subscribe(u => { this.logedIn = (u != null && u.id >= 0); console.log(u); this.user = u; })
  }

  deleteOrderItem(orderItem: OrderItem): void {
    this.order.orderItems.splice(this.order.orderItems.findIndex(oi => oi.orderItemId.product.id === orderItem.orderItemId.product.id), 1);
    this.orderData.changeOrder(this.order);
  }

  onSubmit() {
    if (this.order.orderItems.length > 0) {
      let u = this.user;

      if (u != null && u.id != null) {
        console.log('yo');
        this.order.customer = u;
      }

      console.log(this.order);

      let p = this.order.planedToPickTime;
      this.order.planedToPickTime = new Date(`${p.getDate()}-${p.getMonth() + 1}-${p.getFullYear()}T${p.getHours()}:${p.getMinutes()}:${p.getSeconds()}`);
      this.productService.order(this.order).subscribe(o => { console.log(o); });

      this.orderData.changeOrder(new Order());

      this.bestellt = true;
      this.ordered = true;
    }
  }

  change(orderItem: OrderItem): void {
    this.order.orderItems[this.order.orderItems.findIndex(oi => oi.orderItemId.product.id === orderItem.orderItemId.product.id)] = orderItem;
    this.orderData.changeOrder(this.order);
  }
}
