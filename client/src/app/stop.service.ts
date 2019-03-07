import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError } from 'rxjs/operators';

import { Stop } from "./stop"

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class StopService {

  private stopsUrl = 'http://localhost:8080/stops';
  private routesUrl = 'http://localhost:8080/routes';

  constructor(private http: HttpClient) { }

  // GET: get all stops from the server
  getStops(): Observable<Stop[]> {
    return this.http.get<Stop[]>(this.stopsUrl).pipe(
      catchError(this.handleError('getStops', [])));
  }

  // GET: return single stop from server
  getStop(id: number): Observable<Stop> {
    const url = `${this.stopsUrl}/${id}`;
    return this.http.get<Stop>(url).pipe(
      catchError(this.handleError<Stop>(`getStop id=${id}`))
    );
  }

  // POST: add a new stop to the server
  addStop(stop: Stop): Observable<Stop> {
    return this.http.post<Stop>(this.stopsUrl, stop, httpOptions).pipe(
      catchError(this.handleError<Stop>('addStop'))
    );
  }

  // PUT: update stop in the server
  updateStop(stop: Stop, id: number): Observable<Stop> {
    const url = `${this.stopsUrl}/${id}`;
    return this.http.put(url, stop, httpOptions).pipe(
      catchError(this.handleError<any>('updateStop'))
    );
  }

  // DELETE: delete a stop from the server
  deleteStop(stop: Stop | number): Observable<Stop> {
    const id = typeof stop === 'number' ? stop : stop.id;
    const url = `${this.stopsUrl}/${id}`;

    return this.http.delete<Stop>(url, httpOptions).pipe(
      catchError(this.handleError<Stop>('deleteStop'))
    );
  }

  // GET: all stops on given route
  getStopsOnRoute(id: number): Observable<Stop[]> {
    const url = `${this.routesUrl}/${id}/stops`;
    return this.http.get<Stop[]>(url).pipe(
      catchError(this.handleError('getStops', [])));
  }

  // POST: add a stop to route
  addStopToRoute(routeId: number, stops: Stop[]): Observable<Stop> {
    const url = `${this.routesUrl}/${routeId}/stops`;
    console.log(url);
    console.log(stops);
    return this.http.post<Stop>(url, stops, httpOptions).pipe(
      catchError(this.handleError<Stop>('deleteStop'))
    );
  }

  // DELETE: delete a stop from route
  deleteStopFromRoute(routeId: number, stopId: number): Observable<Stop> {
    const url = `${this.routesUrl}/${routeId}/stops/${stopId}`;
    return this.http.delete<Stop>(url, httpOptions).pipe(
      catchError(this.handleError<Stop>('deleteStop'))
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
