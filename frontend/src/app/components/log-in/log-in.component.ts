import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import { Router } from '@angular/router';
import {AppService} from "../../services/app.service";


@Component({
  selector: 'app-log-in',
  templateUrl: './log-in.component.html',
  styleUrls: ['./log-in.component.css']
})
export class LogInComponent implements OnInit {

  constructor(private http: HttpClient, private svc: AppService, private router: Router) {
    this.svc.setCurrentSite('Log In');
  }

  ngOnInit(): void {
  }

  singInChangeWindow() {
  var container = document.getElementById('container')!;
    container.classList.remove("right-panel-active");

  }

  singUpChangeWindow() {
  var container = document.getElementById('container')!;
    container.classList.add("right-panel-active");
  }


  register() {

    var name = (<HTMLInputElement>document.getElementById("usernameRegister")).value;
    var password = (<HTMLInputElement>document.getElementById("passwordRegister")).value;
    this.http.post('http://localhost:4200/user', {  username: name, pasword: password}).subscribe();
    console.log("test send data to server: "+name + " , " + password );
  }

  signIn(pageName:string) {
    console.log("test")
    this.router.navigate([`${pageName}`]);

    this.http.get('http://localhost:4200/user/all').subscribe(response => {
      console.log(response);
    })
  }
}
