import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {User} from "../models/User";
import {BehaviorSubject, map, Observable} from "rxjs";
import {Router} from "@angular/router";
import { LogInDTO } from '../models/LogInDTO';
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  apiUrl = environment.apiUrl;

  private userSubject: BehaviorSubject<User | null>;
  public user: Observable<User | null>;
  public success: boolean = false;

  constructor(private http: HttpClient, private router: Router) {
    console.log(this.userSubject);
    if(localStorage.getItem('user') !== undefined && localStorage.getItem('user') !== null) {
      console.log("hi");
      this.userSubject = new BehaviorSubject<User | null>(JSON.parse(localStorage.getItem('user') || '{}'));
      console.log(this.userSubject);
      this.user = this.userSubject.asObservable();
      // this.checkUser();
      this.user.subscribe(u => console.log(u));
    }
  }

  public get userValue(): User | null {
    return this.userSubject.value;
  }

  // checkUser() {
  //   let userId = localStorage.getItem('user');
  //   console.log(userId);
  //   if (userId != null) {
  //     this.getById(userId).subscribe(u => {this.userSubject.next(u); console.log(u)});
  //   }
  // }


  register(user: User): Observable<LogInDTO> {
    console.log(user);

    localStorage.removeItem('user');
    this.userSubject.next(null);
    return this.http.post<LogInDTO>(`${this.apiUrl}/customer/signUp`, user);
  }

  getAll() {
    return this.http.get<User[]>(`${this.apiUrl}/customer`);
  }

  getById(id: string) {
    return this.http.get<User>(`${this.apiUrl}/customer/${id}`);
  }

  getKlimaboxById(id: string) {
    return this.http.get<User>(`${this.apiUrl}/product/klimaBox/${id}`);
  }

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

  getPeople(): Observable<User[]> {
    return this.http.get<User[]>(environment.apiUrl + '/customer', {
      headers: {},
    });
  }



}
