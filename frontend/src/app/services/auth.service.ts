import { Injectable } from '@angular/core';
import {LogInDTO} from "../models/LogInDTO";
import {BehaviorSubject, map, Observable} from "rxjs";
import {User} from "../models/User";
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

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

  login(username: any, password: any): Observable<any> {
    return this.http.post(`http://localhost:8080/person/signIn/${username}/${password}`, {username, password});
  }

  isLoggedIn(): boolean {
    const n = new Date().getTime() / 1000;
    const exp = Number(localStorage.getItem('expires_at'));
    let loggedIn: boolean = false;
    //return n < exp;
    if(localStorage.getItem('id_token') !== undefined && localStorage.getItem('id_token') !== null) {
      loggedIn = true;
    }
    return loggedIn;
  }

  logout() {
    // remove user from local storage and set current user to null
    localStorage.removeItem('user');
    localStorage.removeItem('expires_at');
    this.userSubject.next(null);
    this.router.navigate(['/login']);
  }
}
