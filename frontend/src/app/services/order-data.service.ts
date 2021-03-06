import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Order } from '../models/Order';

@Injectable({
  providedIn: 'root'
})
export class OrderDataService {
  private orderSource = new BehaviorSubject<Order>(new Order());
  currentOrder = this.orderSource.asObservable();

  constructor() {
    // let order = localStorage.getItem('order');
    // if (order != null) {
    //   let o: Order = JSON.parse(order);
    //   console.log(o);
    //   this.changeOrder(o);
    // }
  }

  changeOrder(order: Order) {
    this.orderSource.next(order);
    localStorage.setItem('order', JSON.stringify(order));
  }
}
