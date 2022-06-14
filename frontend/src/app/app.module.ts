import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { OrderComponent } from './components/order/order.component';
import { RegisterComponent } from './components/register/register.component';
import { ShoppingCartComponent } from './components/shopping-cart/shopping-cart.component';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { OrderEndComponent } from './components/order-end/order-end.component';
import { MenuComponent } from './components/menu/menu.component';
import { ProductMenuComponent } from './components/product-menu/product-menu.component';
import { MenuImgComponent } from './components/menu-img/menu-img.component';
import { HomePageProductComponent } from './components/home-page-product/home-page-product.component';
import { ProductCategoryComponent } from './components/product-category/product-category.component';
<<<<<<< HEAD
import { ShoppingCartItemComponent } from './components/shopping-cart-item/shopping-cart-item.component';
=======
import {ReactiveFormsModule} from "@angular/forms";
>>>>>>> 577be2466ae4a5a1b5a0ad4478d475604034316b

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    OrderComponent,
    RegisterComponent,
    ShoppingCartComponent,
    OrderEndComponent,
    MenuComponent,
    ProductMenuComponent,
    MenuImgComponent,
    HomePageProductComponent,
    ProductCategoryComponent,
    ShoppingCartItemComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        HttpClientModule,
        FontAwesomeModule,
        ReactiveFormsModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
