import { Component, OnInit } from '@angular/core'
import { Route } from '../route'
import { RouteService} from '../route.service'

@Component({
  selector: 'app-routes',
  templateUrl: './routes.component.html',
  styleUrls: ['./routes.component.scss']
})
export class RoutesComponent implements OnInit {

  routes: Route[];

  constructor(private routeService: RouteService) { }
  

  ngOnInit() {
    this.getRoutes();
  }

  getRoutes(): void {
    this.routeService.getRoutes()
    .subscribe(routes => this.routes = routes);
  }
}
