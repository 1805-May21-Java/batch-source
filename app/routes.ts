import { Routes } from '@angular/router';

import { HighlightcomponentComponent } from './highlightcomponent/highlightcomponent.component';
import { ProfilecomponentComponent } from './profilecomponent/profilecomponent.component';
import { SelectcomponentComponent } from './selectcomponent/selectcomponent.component';
import { TablecomponentComponent } from './tablecomponent/tablecomponent.component';
import { UsercomponentComponent } from './usercomponent/usercomponent.component';

export const appRoutes: Routes = [
    {
        path: 'highlight',
        component: HighlightcomponentComponent
    },
    {
        path: 'profile',
        component: ProfilecomponentComponent
    },
    {
        path: 'select',
        component: SelectcomponentComponent
    },
    {
        path: 'table',
        component: TablecomponentComponent
    },
    {
        path: 'users',
        component: UsercomponentComponent
    }
]