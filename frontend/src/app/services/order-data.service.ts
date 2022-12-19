import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Order } from '../models/Order';
import { ApiService } from './api.service';

@Injectable({
  providedIn: 'root'
})
export class OrderDataService {
  private orderSource = new BehaviorSubject<Order>(new Order());
  currentOrder = this.orderSource.asObservable();


  constructor(private ls: ApiService) {
    let order = localStorage.getItem('order');
    if (order != null) {
      let o: Order = JSON.parse(order);
      o.planedToPickTime = new Date(o.planedToPickTime);
      this.changeOrder(o);
    }
  }

  changeOrder(order: Order) {
    this.orderSource.next(order);
    localStorage.setItem('order', JSON.stringify(order));
  }
}
