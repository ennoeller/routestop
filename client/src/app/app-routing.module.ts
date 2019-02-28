import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { StopsComponent} from './stops/stops.component';
import { StopDetailsComponent } from './stop-details/stop-details.component';

import { RoutesComponent} from './routes/routes.component';
import { RouteDetailsComponent } from './route-details/route-details.component';

const routes: Routes = [
  { path: '', redirectTo: '/stops', pathMatch: 'full'},
  { path: 'stops', component: StopsComponent },
  { path: 'stops/:id', component: StopDetailsComponent},
  { path: 'routes', component: RoutesComponent },
  { path: 'routes/:id', component: RouteDetailsComponent}
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule { }
