import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Order } from '../models/Order';
import { ApiService } from './api.service';
import { environment } from "../../environments/environment";

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
}

const BASE_URL = environment.apiUrl;

@Injectable({
  providedIn: 'root'
})
export class OrderDataService {
  private orderSource = new BehaviorSubject<Order>(new Order());
  currentOrder = this.orderSource.asObservable();


  constructor(private ls: ApiService, private http: HttpClient) {
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

  getUserOrders(id: number): Observable<Order[]> {
    return this.http.get<Order[]>(BASE_URL + '/order/byUserId/' + id);
  }
}
