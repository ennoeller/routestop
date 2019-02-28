import { Component, OnInit, Input } from '@angular/core';
import { Route } from "../route"
import { ActivatedRoute } from '@angular/router'
import { Location } from '@angular/common'
import { RouteService } from '../route.service'

@Component({
  selector: 'app-route-details',
  templateUrl: './route-details.component.html',
  styleUrls: ['./route-details.component.scss']
})
export class RouteDetailsComponent implements OnInit {

  @Input() route: Route;

  constructor(
    private routeA: ActivatedRoute,
    private routeService: RouteService,
    private location: Location
    ) {}

  ngOnInit(): void {
    this.getRoute();
  }

  getRoute(): void {
    const id = +this.routeA.snapshot.paramMap.get('id');
    this.routeService.getRoute(id)
      .subscribe(route => this.route = route);
  }

  goBack(): void {
    this.location.back();
  }

}