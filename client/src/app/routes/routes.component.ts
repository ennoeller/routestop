import { Component, OnInit } from '@angular/core';
import { Route } from '../route';
import { Stop } from '../stop'
import { RouteService} from '../route.service';
import { StopService } from '../stop.service'
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-routes',
  templateUrl: './routes.component.html',
  styleUrls: ['./routes.component.scss']
})
export class RoutesComponent implements OnInit {

  routes: Route[];
  stops: Stop[];
  selectedStops: Stop[];

  constructor(private routeService: RouteService,
              private stopService: StopService) { }
  

  ngOnInit() {
    this.getRoutes();
    this.getStops();
  }

  getRoutes(): void {
    this.routeService.getRoutes()
    .subscribe(routes => this.routes = routes);
  }

  getStops(): void {
    this.stopService.getStops().subscribe(stops => this.stops = stops);
  }
 
  delete(route: Route): void {
    this.routes = this.routes.filter(h => h !== route);
    this.routeService.deleteRoute(route).subscribe();
  }

  add(name: string, description: string, addDate: string, selectedValue: Stop[]): void {
    // TO DO add stops to created route
    let id: number = 0;
    name = name.trim();
    description = description.trim();
    addDate = addDate.trim();
    if (!name && !description && !addDate) { return; }
    this.routeService.addRoute({ id, name, description, addDate } as Route);
  }
}
