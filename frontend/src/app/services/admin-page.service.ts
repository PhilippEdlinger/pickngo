import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from "rxjs";
import { Order } from '../models/Order';
import { environment } from "../../environments/environment";
import { url } from 'inspector';


const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
}

const BASE_URL = environment.apiUrl;

@Injectable({
  providedIn: 'root'
})
export class AdminPageService {
  private orderSource = new BehaviorSubject<Order[]>(this.getOrdersAsArray());
  currentOrder = this.orderSource.asObservable();
  currentStat = 'OPEN';

  constructor(private http: HttpClient) { }

  getAllOpenOrder(): Observable<Order[]> {
    return this.http.get<Order[]>(BASE_URL + '/order/allOpen');
  };

  getAllByOrderStat() {
    return this.http.get<Order[]>(BASE_URL + '/order/' + this.currentStat);
  }

  updateOrders() {
    console.log(this.currentStat);
    this.getAllByOrderStat().subscribe(os => {
      console.log(os);
      this.orderSource.next(os)
    });
  }

  changeOrder(order: Order) {
    const url = BASE_URL + '/order';

    this.http.put(url, order, httpOptions).subscribe(d => this.updateOrders());
  }

  close(id: number) {
    const url = BASE_URL + '/order/close/' + id;

    console.log(url);
    this.http.put(url, {}, httpOptions).subscribe(d => this.updateOrders());
  }

  getOrdersAsArray(): Order[] {
    let o: Order[] = [];
    this.getAllOpenOrder().subscribe(os => o = os);
    return o;
  }
}
