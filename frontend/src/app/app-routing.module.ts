import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import {LogInComponent} from "./components/log-in/log-in.component";

const routes: Routes = [

  {path:'', pathMatch: 'full', redirectTo: 'home'},
  {path: 'login', component: LogInComponent},
  // otherwise redirect to home
  { path: '**', redirectTo: '' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {
    initialNavigation: 'enabled'
  })],
  exports: [RouterModule]
})

export class AppRoutingModule { }
