import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TextComponent } from './components/text/text.component';
import { NavComponent } from './components/nav/nav.component';
import { ProfileDisplayComponent } from './components/profile-display/profile-display.component';
import { SelectComponentComponent } from './select-component/select-component.component';
import { TableComponent } from './components/table/table.component';
import { PageToPopulateComponent } from './components/page-to-populate/page-to-populate.component';

const routes: Routes = [
  {
  path: "text",
  component: TextComponent
  },
  {
    path:"profile",
    component:ProfileDisplayComponent
  },
  {
    path: "nav",
    component: NavComponent
  },
  {
    path:"select",
    component:SelectComponentComponent
  },
  {
    path:"table",
    component:TableComponent
  },
  {
    path:"apiTable",
    component:PageToPopulateComponent
  },
  {
    path:"",
    redirectTo: "/nav",
    pathMatch:"full"
  }
]
@NgModule({
  imports: [
    [RouterModule.forRoot(routes)]
  ],
  exports:[RouterModule],
  declarations: []
})
export class RoutingModule { }
