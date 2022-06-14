import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Order } from '../models/Order';

@Injectable({
  providedIn: 'root'
})
export class OrderDataService {
  private orderSource = new BehaviorSubject<Order>(new Order());
  currentOrder = this.orderSource.asObservable();

  constructor() { }

  changeOrder(order: Order) {
    this.orderSource.next(order);
  }
}
