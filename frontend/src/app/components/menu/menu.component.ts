import {Component, OnInit, Output, EventEmitter, Input, SimpleChanges} from '@angular/core';
import { faShoppingCart,faUser, faPiggyBank } from "@fortawesome/free-solid-svg-icons";
import { Router } from '@angular/router';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.scss']
})
export class MenuComponent implements OnInit {
  @Output() onHideShoppC = new EventEmitter();
  @Input() text: String;
  shoppingCartIcon = faShoppingCart;
  klimaBoxIcon = faPiggyBank;
  userIcon = faUser;
  isOnLoginPage = false;
  shoppingCartItemCounter: number = 99;

  constructor(private router: Router) {
    this.router.events.subscribe(e => {
      this.isOnLoginPage = !(this.router.url.includes('register') || this.router.url.includes('login'));
    })
  }

  ngOnInit(): void {

  }


  searchText: string = '';

  onSearchTextEntered(searchValue: string) {
    this.searchText = searchValue;
    console.log(this.searchText);
  }

  onClickShoppingCart() {
    this.onHideShoppC.emit();
  }

}
