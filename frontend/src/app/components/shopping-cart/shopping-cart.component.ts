import { Component, OnInit, Input, Output, EventEmitter, ViewChild, ElementRef, SimpleChanges } from '@angular/core';
import { faXmark } from '@fortawesome/free-solid-svg-icons';
import { Order } from 'src/app/models/Order';
import { OrderItem } from 'src/app/models/OrderItem';
import { OrderDataService } from 'src/app/services/order-data.service';
import { DatePipe } from '@angular/common';


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
  date1: any = new Date();
  shoppingCartDate: Date = new Date();


  constructor(private orderData: OrderDataService, private datePipe: DatePipe) {
  }

  ngOnChanges(changes: SimpleChanges) {
    if(!this.hide) {
      this.shoppingCartDate = new Date();
      this.shoppingCartDate.setMinutes(this.shoppingCartDate.getMinutes() + 50);
    }
    console.log(this.hide);
    if (this.firstSelectValue == "andere") {
      this.orderData.currentOrder.subscribe(o => {
        o.planedToPickTime = new Date(this.myDiv.nativeElement.value);
      });
    }
  }

  dateChange() {
    this.orderData.currentOrder.subscribe(o => {
      o.planedToPickTime = new Date(this.myDiv.nativeElement.value);
    });
  }

  onChange() {
    this.date1 = Date.now();
    this.date1 = this.datePipe.transform(this.date1, 'yyyy-MM-ddThh:mm');
    setTimeout(() => {
      if (this.firstSelectValue == "andere") {
        this.myDiv.nativeElement.value = this.date1;
      }
    }, 1)
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
