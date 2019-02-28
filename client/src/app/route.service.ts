import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';

import { Route } from "./route"
import { ROUTES } from './mock-data/mock-routes'

@Injectable({
  providedIn: 'root'
})
export class RouteService {

  constructor() { }

  getRoutes(): Observable<Route[]> {
    return of(ROUTES);
  }

  getRoute(id: number): Observable<Route> {
    return of(ROUTES.find(route => route.id === id));
  }
}
