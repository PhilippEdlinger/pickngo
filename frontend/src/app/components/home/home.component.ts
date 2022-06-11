import { Component, OnInit } from '@angular/core';
import { faShoppingCart } from "@fortawesome/free-solid-svg-icons";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})

export class HomeComponent implements OnInit {

  hide: boolean = true;
  fa = faShoppingCart;

  constructor() { }

  ngOnInit(): void {
  }

  shoppingCart() {
    this.hide = false;
  }



}
