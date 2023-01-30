import { NgModule } from '@angular/core';
import {PreloadAllModules, RouterModule, Routes} from '@angular/router';
import { AdminPageComponent } from './components/admin-page/admin-page.component';
import { GreenBoxComponent } from './components/green-box/green-box.component';
import { HomeComponent } from "./components/home/home.component";
import { LoginComponent } from "./components/login/login.component";
import { OrderComponent } from "./components/order/order.component";
import { RegisterComponent } from "./components/register/register.component";
import { AuthGuardService } from "./auth/auth.guard";
import { UserOrderViewComponent } from './components/user-order-view/user-order-view.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'order', component: OrderComponent },
  { path: 'logout', component: LoginComponent },
  { path: 'adminPage', component: AdminPageComponent },
  { path: 'klimabox', component: GreenBoxComponent },
  { path: 'myorders', component: UserOrderViewComponent}
];

@NgModule({
  imports: [
      RouterModule.forRoot(routes, {
        initialNavigation: 'enabledBlocking',
        useHash: true,
        preloadingStrategy: PreloadAllModules,
      })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
