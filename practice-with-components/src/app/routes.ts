import { HighlightComponentComponent } from './highlight-component/highlight-component.component';
import { ProfileComponent } from './profile/profile.component';
import { SelectComponent } from './select/select.component';
import { TableComponent } from './table/table.component';
import { UserComponent } from './user/user.component';
import { Routes } from '@angular/router';

export const appRoutes: Routes = [
    {
        path: 'highlight',
        component: HighlightComponentComponent
    },
    {
        path: 'profile',
        component: ProfileComponent
    },
    {
        path: 'select',
        component: SelectComponent
    },
    {
        path:'table',
        component:TableComponent
    },
    {
        path: 'user',
        component: UserComponent
    },
    {
       path: "**",
       pathMatch: 'full',
       redirectTo: ''
    }
]
