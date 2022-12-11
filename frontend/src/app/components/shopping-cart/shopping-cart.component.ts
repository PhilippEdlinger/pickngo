import {Component, OnInit, Input, Output, EventEmitter, ViewChild, ElementRef, SimpleChanges} from '@angular/core';
import { faXmark } from '@fortawesome/free-solid-svg-icons';
import { Order } from 'src/app/models/Order';
import { OrderItem } from 'src/app/models/OrderItem';
import { OrderDataService } from 'src/app/services/order-data.service';
import { TollFreeInstance } from 'twilio/lib/rest/api/v2010/account/availablePhoneNumber/tollFree';

@Component({
  selector: 'app-shopping-cart',
  templateUrl: './shopping-cart.component.html',
  styleUrls: ['./shopping-cart.component.scss']
})
export class ShoppingCartComponent implements OnInit {
  @Input() hide: boolean = true;
  hideInput: boolean = true;
  order: Order;
  @Output() closeShoppC = new EventEmitter();
  faClose = faXmark;
  sum: number = 0;
  @Input()
  toogleSlider: boolean 
  firstSelectValue: string
  @ViewChild('myElem') myDiv: ElementRef;
  date: Date;


  constructor(private orderData: OrderDataService) { }

  ngOnChanges(changes: SimpleChanges) {
    if(this.firstSelectValue == "andere") {
      //this.date = this.myDiv.nativeElement.value.toDate();
    }
  }

  ngOnInit(): void {
    this.firstSelectValue = "gleich"
    this.toogleSlider = false;
    this.orderData.currentOrder.subscribe(o => {
      this.order = o;
      this.sum = 0;
      for (let oi of o.orderItems) {
        this.sum += oi.orderItemId.product.price * oi.quantity;
      }
    });

    console.log(this.order)
    console.log(this.order.planedToPickTime);
  }

  onClose(): void {
    this.closeShoppC.emit();
  }

  deleteOrderItem(orderItem: OrderItem): void {
    this.order.orderItems.splice(this.order.orderItems.findIndex(oi => oi.orderItemId.product.id === orderItem.orderItemId.product.id), 1);
    console.log(this.order);
    this.orderData.changeOrder(this.order);
  }

  change(orderItem: OrderItem): void {
    //console.log(this.myDiv.nativeElement.value.toDate);
    this.order.orderItems[this.order.orderItems.findIndex(oi => oi.orderItemId.product.id === orderItem.orderItemId.product.id)] = orderItem;
    console.log(this.order);
    this.orderData.changeOrder(this.order);
  }
}
