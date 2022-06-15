import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {User} from "../models/User";
import {BehaviorSubject, map, Observable} from "rxjs";
import {Router} from "@angular/router";
import { LogInDTO } from '../models/LogInDTO';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  apiUrl = 'http://localhost:8080';

  private userSubject: BehaviorSubject<User | null>;
  public user: Observable<User | null>;

  constructor(private http: HttpClient, private router: Router) {
    this.userSubject = new BehaviorSubject<User | null>(JSON.parse(localStorage.getItem('user') || '{}'));
    this.user = this.userSubject.asObservable();
  }

  public get userValue(): User | null {
    return this.userSubject.value;
  }

  login(username: any, password: any) {
    return this.http.post<User>(`http://localhost:8080/person/signIn/${username}/${password}`, {username, password})
        .pipe(map((user: User) => {
          // store user details and jwt token in local storage to keep user logged in between page refreshes
          console.log(user);
          localStorage.setItem('user', JSON.stringify(user));
          this.userSubject.next(user);
          return user;
        }));
  }

  logout() {
    // remove user from local storage and set current user to null
    localStorage.removeItem('user');
    this.userSubject.next(null);
    this.router.navigate(['/login']);
  }

  register(user: User): Observable<LogInDTO> {
    console.log(user);
    return this.http.post<LogInDTO>(`${this.apiUrl}/customer/signUp`, user);
  }

  getAll() {
    return this.http.get<User[]>(`${this.apiUrl}/customer`);
  }

  getById(id: string) {
    return this.http.get<User>(`${this.apiUrl}/customer/${id}`);
  }

 /* update(id: any, params: any) {
    return this.http.put(`${this.apiUrl}/customer/${id}`, params)
        .pipe(map(x => {
          // update stored user if the logged in user updated their own record
          if (id == this.userValue.id) {
            // update local storage
            const user = { ...this.userValue, ...params };
            localStorage.setItem('user', JSON.stringify(user));

            // publish updated user to subscribers
            this.userSubject.next(user);
          }
          return x;
        }));
  }*/

  delete(id: string) {
    return this.http.delete(`${this.apiUrl}/customer/${id}`)
        .pipe(map(x => {
          // auto logout if the logged in user deleted their own record
          /*if (id == this.userValue.id) {
            this.logout();
          }*/
          return x;
        }));
  }

  getPeople(): Observable<User[]> {
    return this.http.get<User[]>('http://localhost:8080/customer', {
      headers: {},
    });
  }



}
