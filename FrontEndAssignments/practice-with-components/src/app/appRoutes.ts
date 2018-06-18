import { Routes } from '@angular/router';

import { ProfileComponent } from './profile/profile.component';
import { HighlightComponent } from './highlight/highlight.component';
import { SelectComponent } from './select/select.component';
import { TableComponent } from './table/table.component';
import { UserComponent } from './user/user.component';

export const appRoutes = [
    {
        path: 'highlight',
        component: HighlightComponent
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
        path: 'table',
        component: TableComponent
    },
    {
        path: 'user',
        component: UserComponent
    }
];