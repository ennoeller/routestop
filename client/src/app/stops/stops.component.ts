import { Component, OnInit } from '@angular/core';

import { Stop } from '../Stop';
import { StopService } from '../stop.service';

@Component({
  selector: 'app-stops',
  templateUrl: './stops.component.html',
  styleUrls: ['./stops.component.scss']
})
export class StopsComponent implements OnInit {

  stops: Stop[];

  constructor(private stopService: StopService) { }


  ngOnInit() {
    this.getStops();
  }

  getStops(): void {
    this.stopService.getStops()
      .subscribe(stops => this.stops = stops);
  }

  // Add stop
  add(stopId: number, name: string, coordinates: string): void {
    let id: number = 0;
    name = name.trim();
    coordinates = coordinates.trim();
    if (!name && !coordinates && !stopId) { return; }
    this.stopService.addStop({ id, stopId, name, coordinates } as Stop)
      .subscribe(stop => this.stops.push(stop));
  }

  // Delete stop
  delete(stop: Stop): void {
    this.stops = this.stops.filter(h => h !== stop);
    this.stopService.deleteStop(stop).subscribe();
  }
}
