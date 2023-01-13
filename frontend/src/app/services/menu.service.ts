import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Product } from '../models/Product';
import { Menu } from '../models/Menu';
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class MenuService {

  private apiUrl: String = environment.apiUrl + '/menu';

  constructor( private http: HttpClient ) { }

  getDishOfTheDay(): Observable<Menu[]> {
    const u = `${this.apiUrl}/dishoftheday`;
    return this.http.get<Menu[]>(u);
  }
}
