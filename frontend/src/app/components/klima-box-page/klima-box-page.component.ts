import { Component, OnInit, Input } from '@angular/core';
import { Order } from 'src/app/models/Order';
import { OrderItem } from 'src/app/models/OrderItem';
import { OrderItemID } from 'src/app/models/OrderItemID';
import { Product } from 'src/app/models/Product';
import { OrderDataService } from 'src/app/services/order-data.service';

@Component({
  selector: 'app-klima-box-page',
  templateUrl: './klima-box-page.component.html',
  styleUrls: ['./klima-box-page.component.scss']
})
export class KlimaBoxPageComponent implements OnInit {

  @Input() product: Product;
  order: Order;
  bestellt: boolean = false;

  count = 20;
  counter(){
    if (this.count == 0){
      this.count = 0;
    }else{
      this.count--
    }
  }


  constructor(private orderData: OrderDataService) { }

  ngOnInit(): void {
    this.product.imageName = 'http://localhost:8080/product/img/' + this.product.imageName;
    this.orderData.currentOrder.subscribe(order => this.order = order);
  }



  onClick() {
    this.counter();

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
  }
}
