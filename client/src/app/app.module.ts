import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';

import { StopsComponent } from './stops/stops.component';
import { StopDetailsComponent } from './stop-details/stop-details.component';
import { RoutesComponent } from './routes/routes.component';
import { RouteDetailsComponent } from './route-details/route-details.component';

@NgModule({
  declarations: [
    AppComponent,
    StopsComponent,
    StopDetailsComponent,
    RoutesComponent,
    RouteDetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
