import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from "rxjs";
import { Order } from '../models/Order';


const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
}

const BASE_URL = 'http://localhost:8080';

@Injectable({
  providedIn: 'root'
})
export class AdminPageService {
  private orderSource = new BehaviorSubject<Order[]>(this.getOrdersAsArray());
  currentOrder = this.orderSource.asObservable();

  constructor(private http: HttpClient) { }

  getAllOpenOrder(): Observable<Order[]> {
    return this.http.get<Order[]>(BASE_URL + '/order/allOpen');
  };

  updateOrders() {
    this.getAllOpenOrder().subscribe(os => this.orderSource.next(os));
  }

  close(id: number) {
    const url = BASE_URL + '/order/close/' + id;
    this.http.put(url, httpOptions);

    this.updateOrders();
  }

  getOrdersAsArray(): Order[] {
    let o:Order[] = [];
    this.getAllOpenOrder().subscribe(os => o = os);
    return o;
  }
}
