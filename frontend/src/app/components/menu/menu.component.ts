import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { faShoppingCart } from "@fortawesome/free-solid-svg-icons";

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.scss']
})
export class MenuComponent implements OnInit {
  @Output() onHideShoppC = new EventEmitter();
  shoppingCartIcon = faShoppingCart;

  constructor() { }

  ngOnInit(): void {
  }

  onClickShoppingCart() {
    this.onHideShoppC.emit();
  }

}
