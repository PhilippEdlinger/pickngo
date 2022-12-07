import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminPageComponent } from './components/admin-page/admin-page.component';
import { GreenBoxComponent } from './components/green-box/green-box.component';
import {HomeComponent} from "./components/home/home.component";
import {LoginComponent} from "./components/login/login.component";
import {OrderComponent} from "./components/order/order.component";
import {RegisterComponent} from "./components/register/register.component";
import {AuthGuardService} from "./auth/auth.guard";

const routes: Routes = [
  { path: '', component: HomeComponent},
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'order', component: OrderComponent },
  { path: 'logout', component: LoginComponent },
  { path: 'adminPage', component: AdminPageComponent,
    canActivate: [AuthGuardService]
  },
  { path: 'klimabox', component: GreenBoxComponent,
    canActivate: [AuthGuardService]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
