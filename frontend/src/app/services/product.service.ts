import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Product } from '../models/Product';
import { Order } from '../models/Order';
import {Menu} from "../models/Menu";

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
}

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private apiUrl: String = 'http://localhost:8080/product';

  constructor(private http: HttpClient) { }

  getProductCategory(urlName: String): Observable<Product[]> {
    const u = `${this.apiUrl}/${urlName}`;
    return this.http.get<Product[]>(u);
  }

  getAllProducts(): Observable<Product[]> {
    const u = `${this.apiUrl}`;
    return this.http.get<Product[]>(u);
  }

  getSearchResult(sw: String): Observable<Product[]> {
    const u = `${this.apiUrl}/search/${sw}`;
    return this.http.get<Product[]>(u);
  }

  order(order: Order): Observable<Order> {
    console.log(order);
    return this.http.post<Order>('http://localhost:8080/order', order, httpOptions);
  }

  getAllOrder(): Observable<Order[]> {
    return this.http.get<Order[]>('http://localhost:8080/order');
  }
}
