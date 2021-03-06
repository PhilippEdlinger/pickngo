import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Observable } from 'rxjs';
import { LogInDTO } from 'src/app/models/LogInDTO';
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
  ordered = false;
  form: FormGroup;
  logedIn: boolean = false;
  user: any;
  bestellt: boolean = false;

  constructor(private orderData: OrderDataService, private fb: FormBuilder, private productService: ProductService, private ls: ApiService) {
    this.form = this.fb.group({
      tele: [null, Validators.required, Validators.minLength(7), Validators.maxLength(20)]
    });
  }

  ngOnInit(): void {
    this.orderData.currentOrder.subscribe(o => this.order = o);
    this.ls.user.subscribe(u => { this.logedIn = (u != null && u!.id >= 0); this.user = u; })
  }

  deleteOrderItem(orderItem: OrderItem): void {
    this.order.orderItems.splice(this.order.orderItems.findIndex(oi => oi.orderItemId.product.id === orderItem.orderItemId.product.id), 1);
    console.log(this.order);
    this.orderData.changeOrder(this.order);
  }

  onSubmit() {
    if (this.order.orderItems.length > 0) {

      let us = this.user as LogInDTO;
      let u = us.person as User;
      console.log(u);
      if (u != null && u.id != null) {
        console.log('yo');
        this.order.customer = u;
      }

      let p = this.order.planedToPickTime;
      this.order.planedToPickTime = new Date(`${p.getDate()}-${p.getMonth() + 1}-${p.getFullYear()}T${p.getHours()}:${p.getMinutes()}:${p.getSeconds()}`);
      console.log(this.order);
      this.productService.order(this.order).subscribe(o => { console.log(o); });

      this.orderData.changeOrder(new Order());

      this.bestellt = true;
      setTimeout(() => {
        this.bestellt = false;
      }, 7000);
    }
  }
}
