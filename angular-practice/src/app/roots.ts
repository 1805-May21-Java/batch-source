import { Routes } from '@angular/router'
import { HighlightComponent } from './highlight/highlight.component';
import { ProfileComponent } from './profile/profile.component';
import { SelectComponent } from './select/select.component';
import { TableComponent } from './table/table.component';
import { UsergenComponent } from './usergen/usergen.component';

export const appRoutes: Routes = [
    {
        path: "highlight",
        component: HighlightComponent
    },
    {
        path: "profile",
        component: ProfileComponent
    },
    {
        path: 'select',
        component: SelectComponent
    },
    {
        path: 'table',
        component: TableComponent
    },
    {
        path: 'usergen',
        component: UsergenComponent
    }
]