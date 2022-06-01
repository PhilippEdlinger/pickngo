import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  hide: boolean = true;

  constructor() { }

  ngOnInit(): void {
  }

  shoppingCart() {
    this.hide = false;
  }



}
