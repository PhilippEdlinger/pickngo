import {Component, Input, OnInit} from '@angular/core';
import {Menu} from "../../models/Menu";
import {Product} from "../../models/Product";
import {MenuService} from "../../services/menu.service";
import {ProductService} from "../../services/product.service";

@Component({
  selector: 'app-green-box',
  templateUrl: './green-box.component.html',
  styleUrls: ['./green-box.component.scss']
})
export class GreenBoxComponent implements OnInit {
  menus: Menu[];
  @Input() products: Product;

  ngOnInit(): void {
  }

  config: any;
  fullpage_api: any;

  constructor(private menuService: MenuService, private productService: ProductService) {

    // for more details on config options please visit fullPage.js docs
    this.config = {

      // fullpage options
      licenseKey: 'YOUR LICENSE KEY HERE',
      anchors: ['firstPage', 'secondPage', 'thirdPage', 'fourthPage', 'lastPage'],
      menu: '#menu',

      // fullpage callbacks
      afterResize: () => {
        console.log("After resize");
      },
      afterLoad: (origin: { index: any; }, destination: any, direction: any) => {
        console.log(origin.index);
      }
    };
  }

  getRef(fullPageRef: any) {
    this.fullpage_api = fullPageRef;
  }

}

