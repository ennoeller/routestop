import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router'
import { Location } from '@angular/common'

import { StopService } from '../stop.service'
import { RouteService } from '../route.service'
import { Stop } from '../stop'
import { Route } from "../route"

@Component({
  selector: 'app-route-details',
  templateUrl: './route-details.component.html',
  styleUrls: ['./route-details.component.scss']
})
export class RouteDetailsComponent implements OnInit {

  @Input() route: Route;

  stops: Stop[];
  allStops: Stop[];

  constructor(
    private stopService: StopService,
    private routeA: ActivatedRoute,
    private routeService: RouteService,
    private location: Location
  ) { }

  ngOnInit(): void {
    this.getRoute();
    this.getStopsOnRoute();
    this.getAllStops();
  }

  getRoute(): void {
    const id = +this.routeA.snapshot.paramMap.get('id');
    this.routeService.getRoute(id)
      .subscribe(route => this.route = route);
  }

  // add stops to route
  add(routeId: number, stops: Stop[]) {
    this.stopService.addStopToRoute(routeId, stops).subscribe();
    stops.push();
  }

  updateRoute(): void {
    const id = +this.routeA.snapshot.paramMap.get('id');
    this.routeService.updateRoute(this.route, id).subscribe();
  }

  getAllStops() {
    this.stopService.getStops().subscribe(stops => this.allStops = stops);
  }

  getStopsOnRoute() {
    const id = +this.routeA.snapshot.paramMap.get('id');
    this.stopService.getStopsOnRoute(id)
      .subscribe(stops => this.stops = stops);
  }

  deleteStopFromRoute(stop: Stop): void {
    const routeId = +this.routeA.snapshot.paramMap.get('id');
    var stopId: number = stop.id;
    this.stops = this.stops.filter(h => h !== stop);
    this.stopService.deleteStopFromRoute(routeId, stopId).subscribe();
  }

  goBack(): void {
    this.location.back();
  }
}