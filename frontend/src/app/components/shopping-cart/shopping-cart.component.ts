import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { faXmark } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-shopping-cart',
  templateUrl: './shopping-cart.component.html',
  styleUrls: ['./shopping-cart.component.scss']
})
export class ShoppingCartComponent implements OnInit {
  @Input() hide: boolean = true;
  @Output() closeShoppC = new EventEmitter();
  faClose = faXmark;
  constructor() { }

  ngOnInit(): void {
  }

  onClose() {
    this.closeShoppC.emit();
  }
}
