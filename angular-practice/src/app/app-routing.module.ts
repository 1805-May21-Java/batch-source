import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ApiCallComponent } from './api-call/api-call.component';
import { HighlightComponent } from './highlight/highlight.component';
import { ProfileComponent } from './profile/profile.component';
import { SelectComponent } from './select/select.component';
import { TableComponent } from './table/table.component';

const routes: Routes = [
  {path: 'highlight', component: HighlightComponent},
  {path: 'profile', component: ProfileComponent},
  {path: 'select', component: SelectComponent},
  {path: 'table', component: TableComponent},
  {path: 'apicall', component: ApiCallComponent}
]

@NgModule({
  imports: [ RouterModule.forRoot(routes)],
  exports: [ RouterModule ]
})
export class AppRoutingModule { }
