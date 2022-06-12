import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Product } from '../models/Product';

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
}
