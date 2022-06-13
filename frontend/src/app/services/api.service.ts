import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {User} from "../models/User";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(private http: HttpClient) {}

  login(username: string, password: string) {
    return this.http.post<User>(`http://localhost:8080/person/signIn${username}/${password}`, {username, password})
  }

  getPeople(): Observable<User[]> {
    return this.http.get<User[]>('http://localhost:8080/customer', {
      headers: {},
    });
  }

}
