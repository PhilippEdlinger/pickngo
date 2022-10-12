import {Component, OnInit, Output, EventEmitter, Input} from '@angular/core';
import { faShoppingCart } from "@fortawesome/free-solid-svg-icons";

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.scss']
})
export class MenuComponent implements OnInit {
  @Output() onHideShoppC = new EventEmitter();
  @Input() text =  (<HTMLInputElement>document.getElementById("searchbar")).value;
  shoppingCartIcon = faShoppingCart;


  constructor() { }

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
