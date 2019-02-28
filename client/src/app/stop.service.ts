import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';

import { Stop } from "./stop"
import { STOPS } from './mock-data/mock-stops'

@Injectable({
  providedIn: 'root'
})
export class StopService {

  constructor() { }

  getStops(): Observable<Stop[]> {
    return of(STOPS);
  }

  getStop(id: number): Observable<Stop> {
    return of(STOPS.find(stop => stop.id === id));
  }
}
