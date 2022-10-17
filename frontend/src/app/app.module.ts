import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import {MatInputModule} from '@angular/material/input';

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
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { AdminPageComponent } from './components/admin-page/admin-page.component';
import { AdminPageItemComponent } from './components/admin-page-item/admin-page-item.component';
import { SearchbarComponent } from './components/searchbar/searchbar.component';
import { SmsComponent } from './components/sms/sms.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

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
    SmsComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        HttpClientModule,
        MatInputModule,
        FontAwesomeModule,
        ReactiveFormsModule,
        FormsModule,
        BrowserAnimationsModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
