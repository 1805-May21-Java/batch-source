import { Routes } from '@angular/router';
import { FirstComponent } from './components/first/first.component';
import { DatabindComponent } from './components/databind/databind.component';
import { ClickerComponent } from './components/clicker/clicker.component';
import { PipesDemoComponent } from './components/pipes-demo/pipes-demo.component';
import { DirectivesComponent } from './components/directives/directives.component';
import { SDirectivesComponent } from './components/s-directives/s-directives.component';
import { ADirectivesComponent } from './components/a-directives/a-directives.component';
import { HttpExampleComponent } from './components/http-example/http-example.component';
import { PostDetailsComponent } from './components/post-details/post-details.component';

export const appRoutes: Routes = [
    {
        path: 'first',
        component: FirstComponent
    },
    {
        path: 'databind',
        component: DatabindComponent
    },
    {
        path: 'clicker',
        component: ClickerComponent
    },
    {
        path: 'pipes',
        component: PipesDemoComponent
    },
    {
        path: 'directives',
        component: DirectivesComponent,
        children: [
            {
                path: 'structural',
                component: SDirectivesComponent
            },
            {
                path: 'attribute',
                component: ADirectivesComponent
            }
        ]
    },
    {
        path: 'posts',
        component: HttpExampleComponent
    },
    {
        path: 'posts/:id',
        component: PostDetailsComponent
    },
    {
        path: "**",
        pathMatch: 'full',
        redirectTo: ''
    }
]