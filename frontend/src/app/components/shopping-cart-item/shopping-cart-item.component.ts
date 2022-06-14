import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { OrderItem } from 'src/app/models/OrderItem';
import { faTrash } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-shopping-cart-item',
  templateUrl: './shopping-cart-item.component.html',
  styleUrls: ['./shopping-cart-item.component.scss']
})
export class ShoppingCartItemComponent {
  @Input() orderItem: OrderItem;
  @Output() orderItemChange = new EventEmitter<OrderItem>();
  @Output() deleteOrderItem = new EventEmitter();
  faTrash = faTrash;

  constructor() {
  }

  dec() {
    if (this.orderItem.quantity > 0) {
      this.orderItem.quantity--;
      this.orderItemChange.emit(this.orderItem);
    }
  }
  inc() {
    if (this.orderItem.quantity < 100) {
      this.orderItem.quantity++;
      this.orderItemChange.emit(this.orderItem);
    }
  }

  onDelete() {
    this.deleteOrderItem.emit(this.orderItem);
  }
}
