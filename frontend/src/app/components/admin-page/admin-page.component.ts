import { Component, OnInit } from '@angular/core';
import { Order } from 'src/app/models/Order';
import { AdminPageService } from 'src/app/services/admin-page.service';
import { ProductService } from '../../services/product.service';

@Component({
  selector: 'app-admin-page',
  templateUrl: './admin-page.component.html',
  styleUrls: ['./admin-page.component.scss']
})
export class AdminPageComponent implements OnInit {
  orders: Order[];
  orderStats = {
    OPEN: 'Offen',
    IN_PRODUCTION: 'In Proktion',
    READY: 'Bereit',
    SPAM: 'Spam',
    CLOSED: 'Geschlossen'
  };
  buttonTexts = [
    'In Produktion nehmen',
    'Bestellung bereit',
    'Bestellung abschließen',
    '',
    ''
  ]

  constructor(private productService: ProductService, private adminService: AdminPageService) { }

  ngOnInit(): void {
    this.adminService.updateOrders();
    this.adminService.currentOrder.subscribe(os => this.orders = os);

    console.log(this.orderStats);
  }

  onSelectChange(event: Event) {
    const e = event.currentTarget as HTMLSelectElement;
    this.adminService.currentStat = e.value;

    this.adminService.updateOrders();
  }
}
