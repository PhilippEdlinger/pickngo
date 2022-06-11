import { Component, OnInit } from '@angular/core';
import { Menu } from 'src/app/models/Menu';
import { Product } from 'src/app/models/Product';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})

export class HomeComponent implements OnInit {
  menus:Menu[];
  vorspeisenProducts:Product[];
  mainProducts:Product[];
  desertProducts:Product[];
  drinkProducts:Product[];
  constructor() { }

  ngOnInit(): void {
  }
}
