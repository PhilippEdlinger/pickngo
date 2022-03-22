import {Component, OnInit} from '@angular/core';
import { UserDetails , Todolist } from './_models';
import {AccountService} from './_services';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent implements OnInit {
  title = 'frontend';
  user: UserDetails;
  todos: Todolist[] = [];

  constructor(private accountService: AccountService) {
    this.accountService.user.subscribe(x => this.user = x);
  }


  ngOnInit(): void {

  }


  logout() {
    this.accountService.logout();
  }

}
