import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Observable} from "rxjs";
import { Product } from '../models/Product';
import { Order } from '../models/Order';
import { Klimabox } from '../models/Klimabox';
import {environment} from "../../environments/environment";

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
}

const BASE_URL = environment.apiUrl;

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http: HttpClient) { }

  getProductCategory(urlName: String): Observable<Product[]> {
    const u = `${BASE_URL}/product/${urlName}`;
    return this.http.get<Product[]>(u);
  }

  getAllProducts(): Observable<Product[]> {
    const u = `${BASE_URL}`;
    return this.http.get<Product[]>(u);
  }

  getSearchResult(sw: String): Observable<Product[]> {
    const u = `${BASE_URL}/product/search/${sw}`;
    return this.http.get<Product[]>(u);
  }

  order(order: Order): Observable<Order> {
    console.log(order);
    return this.http.post<Order>(BASE_URL + '/order', order, httpOptions);
  }

  getAllOrder(): Observable<Order[]> {
    return this.http.get<Order[]>(BASE_URL + '/order');
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
