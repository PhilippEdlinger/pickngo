import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { MatInputModule } from '@angular/material/input';
import { MatMenuModule } from '@angular/material/menu';

import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { OrderComponent } from './components/order/order.component';
import { RegisterComponent } from './components/register/register.component';
import { ShoppingCartComponent } from './components/shopping-cart/shopping-cart.component';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { MenuComponent } from './components/menu/menu.component';
import { ProductMenuComponent } from './components/product-menu/product-menu.component';
import { MenuImgComponent } from './components/menu-img/menu-img.component';
import { HomePageProductComponent } from './components/home-page-product/home-page-product.component';
import { ProductCategoryComponent } from './components/product-category/product-category.component';
import { ShoppingCartItemComponent } from './components/shopping-cart-item/shopping-cart-item.component';
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { AdminPageComponent } from './components/admin-page/admin-page.component';
import { AdminPageItemComponent } from './components/admin-page-item/admin-page-item.component';
import { SearchbarComponent } from './components/searchbar/searchbar.component';
import { SmsComponent } from './components/sms/sms.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgImageSliderModule } from 'ng-image-slider';
import { MatCheckboxModule } from "@angular/material/checkbox";
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { GreenBoxComponent } from './components/green-box/green-box.component';
import { MatBadgeModule } from "@angular/material/badge";
import { KlimaBoxPageComponent } from './components/klima-box-page/klima-box-page.component';
import { KlimaBoxCategoryComponent } from './components/klima-box-category/klima-box-category.component';
import { AuthInterceptor } from "./auth/auth.interceptor";
import { MatDatepickerModule } from "@angular/material/datepicker";
import { MatIconModule } from "@angular/material/icon";
import { APP_BASE_HREF, DatePipe, PlatformLocation } from '@angular/common';
import { UserOrderViewComponent } from './components/user-order-view/user-order-view.component';
import { OrderItemComponent } from './components/order-item/order-item.component';
import { UserOrderViewItemComponent } from './components/user-order-view-item/user-order-view-item.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    OrderComponent,
    RegisterComponent,
    ShoppingCartComponent,
    MenuComponent,
    ProductMenuComponent,
    MenuImgComponent,
    HomePageProductComponent,
    ProductCategoryComponent,
    ShoppingCartItemComponent,
    AdminPageComponent,
    AdminPageItemComponent,
    SearchbarComponent,
    SmsComponent,
    GreenBoxComponent,
    KlimaBoxPageComponent,
    KlimaBoxCategoryComponent,
    UserOrderViewComponent,
    OrderItemComponent,
    UserOrderViewItemComponent,

  ],
  imports: [
    BrowserModule,
    NgImageSliderModule,
    AppRoutingModule,
    HttpClientModule,
    MatInputModule,
    FontAwesomeModule,
    ReactiveFormsModule,
    FormsModule,
    BrowserAnimationsModule,
    MatCheckboxModule,
    MatSlideToggleModule,
    MatBadgeModule,
    MatDatepickerModule,
    MatIconModule,
    MatMenuModule
  ],
  providers: [
    DatePipe,
    {
      provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor,
      multi: true
    },
    {
      provide: APP_BASE_HREF,
      useValue: '/d.altenhofer/'
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
