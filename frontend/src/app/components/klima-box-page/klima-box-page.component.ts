import { Component, OnInit, Input } from '@angular/core';
import { Order } from 'src/app/models/Order';
import { OrderItem } from 'src/app/models/OrderItem';
import { OrderItemID } from 'src/app/models/OrderItemID';
import { Product } from 'src/app/models/Product';
import { ApiService } from 'src/app/services/api.service';
import { OrderDataService } from 'src/app/services/order-data.service';
import { ProductService } from 'src/app/services/product.service';
import { Klimabox } from "../../models/Klimabox";

@Component({
  selector: 'app-klima-box-page',
  templateUrl: './klima-box-page.component.html',
  styleUrls: ['./klima-box-page.component.scss']
})
export class KlimaBoxPageComponent implements OnInit {

  product: Product;
  @Input() klimabox: Klimabox
  order: Order;
  bestellt: boolean = false;
  realCount: any;

  constructor(private orderData: OrderDataService, private apiService: ApiService, private productService:ProductService) {

  }

  ngOnChanges() {
    this.realCount = localStorage.getItem('counter');
  }


  ngOnInit(): void {
    this.product = this.klimabox.product;
    this.product.imageName = 'http://localhost:8080/product/img/' + this.product.imageName;
    this.orderData.currentOrder.subscribe(order => this.order = order);

    console.log(this.klimabox);
  }



  onClick() {
    let oi = new OrderItem();
    let oiId = new OrderItemID();
    oiId.product = this.product;
    oi.orderItemId = oiId;
    this.order.orderItems.push(oi);


    console.log(this.order);
    this.orderData.changeOrder(this.order);


    this.bestellt = true;
    setTimeout(() => {
      this.bestellt = false;
    }, 7000);

    this.productService.updateKlimabox(this.klimabox.id).subscribe(klimabox => this.klimabox = klimabox);
  }
}
