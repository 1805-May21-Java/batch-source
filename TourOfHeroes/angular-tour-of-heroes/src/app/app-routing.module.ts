import { NgModule } from '@angular/core';
import {RouterModule,Routes} from '@angular/router'
import { HeroesComponent } from './components/heroes/heroes.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { HeroDetailComponent } from './hero-detail/hero-detail.component';
import { HttpClient } from 'selenium-webdriver/http';

const routes: Routes=[
  {
    path:'heroes',
    component:HeroesComponent
  },
  {
    path:'dashboard',
    component:DashboardComponent
  },
  {
    path:'detail/:id',
    component:HeroDetailComponent
  },
  {
    path:"",
    redirectTo:'/dashboard',
    pathMatch:'full'
  }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes),
  HttpClient
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }

