import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {map, Observable} from "rxjs";
import { Product } from '../models/Product';
import { Order } from '../models/Order';
import {Menu} from "../models/Menu";
import { Klimabox } from '../models/Klimabox';
import { NumberSymbol } from '@angular/common';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
}

const BASE_URL = 'http://localhost:8080';

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

  getAllKlimaBox(): Observable<Klimabox[]> {
    return this.http.get<Klimabox[]>(BASE_URL + '/product/klimaBox');
  }

  updateKlimabox(id: number): Observable<Klimabox> {
    const url = BASE_URL + '/product/klimaBox/' + id;
    console.log(url);
    return this.http.put<Klimabox>(url, httpOptions);
  }
}
