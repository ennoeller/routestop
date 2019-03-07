import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, map, tap } from 'rxjs/operators';

import { Route } from "./route"

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class RouteService {

  private routesUrl = 'http://localhost:8080/routes';

  constructor(private http: HttpClient) { }

  // GET: get all routes from the server
  getRoutes(): Observable<Route[]> {
    return this.http.get<Route[]>(this.routesUrl).pipe(
      catchError(this.handleError('getRoutes', [])));
  }

  // GET: return single route from server
  getRoute(id: number): Observable<Route> {
    const url = `${this.routesUrl}/${id}`;
    return this.http.get<Route>(url).pipe(
      catchError(this.handleError<Route>(`getRoute id=${id}`))
    );
  }

  // POST: add a new route to the server
  addRoute(route: Route): Observable<Route> {
    return this.http.post<Route>(this.routesUrl, route, httpOptions).pipe(
      catchError(this.handleError<Route>('addRoute'))
    );
  }

  // PUT: update route in the server
  updateRoute(route: Route, id: number): Observable<Route> {
    const url = `${this.routesUrl}/${id}`;
    return this.http.put(url, route, httpOptions).pipe(
      catchError(this.handleError<any>('updateRoute'))
    );
  }

  // DELETE: delete the stop from the server
  deleteRoute(route: Route | number): Observable<Route> {
    const id = typeof route === 'number' ? route : route.id;
    const url = `${this.routesUrl}/${id}`;

    return this.http.delete<Route>(url, httpOptions).pipe(
      catchError(this.handleError<Route>('deleteRoute'))
    );
  }

  /**
  * Handle Http operation that failed.
  * Let the app continue.
  * @param operation - name of the operation that failed
  * @param result - optional value to return as the observable result
  */
  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      console.error(error); // log to console

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }
}
